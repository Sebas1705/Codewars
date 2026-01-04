#include "queue.h"
#include <stdlib.h>

typedef struct Node { struct Node *next; const void *data; } Node;

struct Queue { Node *head, *tail; size_t size; };

Queue *new_queue(void) {
    Queue *q = (Queue*)malloc(sizeof(Queue));
    if (!q) return NULL;
    q->head = q->tail = NULL;
    q->size = 0;
    return q;
}

size_t queue_size(const Queue *q) { return q ? q->size : 0; }

Queue *queue_enqueue(Queue *q, const void *data) {
    if (!q) return NULL;
    Node *n = (Node*)malloc(sizeof(Node));
    if (!n) return q;
    n->next = NULL; n->data = data;
    if (q->tail) q->tail->next = n; else q->head = n;
    q->tail = n; q->size++;
    return q;
}

void *queue_dequeue(Queue *q) {
    if (!q || !q->head) return NULL;
    Node *n = q->head;
    void *d = (void*)n->data;
    q->head = n->next;
    if (!q->head) q->tail = NULL;
    free(n);
    q->size--;
    return d;
}

void free_queue(Queue *q) {
    if (!q) return;
    Node *n = q->head;
    while (n) { Node *t = n->next; free(n); n = t; }
    free(q);
}
