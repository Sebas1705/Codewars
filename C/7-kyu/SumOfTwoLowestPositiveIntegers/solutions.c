#include <stdio.h>
#include <stddef.h>

long long sum_two_smallest_numbers(size_t n, const int numbers[n]) 
{
    int min1 = __INT_MAX__, min2 = __INT_MAX__;
    for (size_t i = 0; i < n; i++) {
        if (numbers[i] < min1) {
            min2 = min1;
            min1 = numbers[i];
        } else if (numbers[i] < min2) {
            min2 = numbers[i];
        }
    }
    return (long long)min1 + (long long)min2;
}


int main()
{
    int arr[] = { 2000000000, 2000000000, 2000000000, 2000000000, 2000000000 };
    size_t n = sizeof(arr) / sizeof(arr[0]);
    long long result = sum_two_smallest_numbers(n, arr);
    printf("The sum of the two smallest positive integers is: %lld\n", result);

    return 0;
}
