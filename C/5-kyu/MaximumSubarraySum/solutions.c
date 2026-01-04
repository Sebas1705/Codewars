#include <stdio.h>
#include <stddef.h>

int maxSequence(const int array[/* n */], size_t n) 
{
    int max_so_far = 0;
    int max_ending_here = 0;

    for (size_t i = 0; i < n; i++) {
        max_ending_here += array[i];
        if (max_ending_here < 0)
            max_ending_here = 0;
        if (max_so_far < max_ending_here)
            max_so_far = max_ending_here;
    }

    return max_so_far;
}

int main()
{
    int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    size_t n = sizeof(array) / sizeof(array[0]);
    int result = maxSequence(array, n);
    printf("Maximum subarray sum: %d\n", result);
    return 0;
}
