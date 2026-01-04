#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>

/* to help you solve the kata, a queue implementation has been
preloaded for you */

typedef struct Queue Queue;

// the queue elements are pointers

// creates a new queue
extern Queue *new_queue (void);
// returns the number of elements in the queue
extern size_t queue_size (const Queue *queue);
// adds an element at the back of the queue and returns the queue
extern Queue *queue_enqueue (Queue *queue, const void *data);
// removes the element at the front of the queue and returns it
extern void *queue_dequeue (Queue *queue);
// frees the queue, do not forget to call it !
extern void free_queue (Queue *queue);
/* ==================================================== */

typedef struct Tree {
	struct Tree *left, *right;
	int value;
} Tree;

int *tree_by_levels (const Tree *tree, size_t *tree_size)
{
    if (!tree) {
        *tree_size = 0;
        return NULL;
    }

    Queue *queue = new_queue();
    queue = queue_enqueue(queue, tree);

    size_t capacity = 16;
    int *result = malloc(capacity * sizeof(int));
    size_t size = 0;

    while (queue_size(queue) > 0) {
        const Tree *node = queue_dequeue(queue);
        if (size >= capacity) {
            capacity *= 2;
            result = realloc(result, capacity * sizeof(int));
        }
        result[size++] = node->value;

        if (node->left) {
            queue = queue_enqueue(queue, node->left);
        }
        if (node->right) {
            queue = queue_enqueue(queue, node->right);
        }
    }

    free_queue(queue);
    *tree_size = size;
    return result;
}

void print_tree(const Tree *tree) {
    if (!tree) return;
    printf("%d ", tree->value);
    print_tree(tree->left);
    print_tree(tree->right);
}

int main()
{
    Tree *tree = &(Tree)
	{
		.value = 1,
		.left = &(Tree)
		{
			.value = 2,
			.left = &(Tree) { .value = 4 },
			.right = &(Tree) { .value = 5 },
		},
		.right = &(Tree)
		{
			.value = 3,
			.left = &(Tree){.value = 6},
			.right = &(Tree)
			{
				.value = 7,
				.left = &(Tree) { .value = 8 }
			}
		}
	};
    print_tree(tree);
    printf("\n");

    size_t tree_size;
    int *result = tree_by_levels(tree, &tree_size);
    for (size_t i = 0; i < tree_size; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");
    free(result);
    return 0;
}
