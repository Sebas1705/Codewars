// Minimal queue implementation used by kata tests
#pragma once

#include <stddef.h>

typedef struct Queue Queue;

Queue *new_queue(void);
size_t queue_size(const Queue *q);
Queue *queue_enqueue(Queue *q, const void *data);
void *queue_dequeue(Queue *q);
void free_queue(Queue *q);
