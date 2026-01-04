#include <stdio.h>

void two_oldest_ages(size_t n, const int ages[n], int result[2])
{
    if (n < 2) {
        return; // Not enough ages to determine the two oldest
    }

    int oldest = -1;
    int second_oldest = -1;

    for (size_t i = 0; i < n; i++) {
        if (ages[i] > oldest) {
            second_oldest = oldest;
            oldest = ages[i];
        } 
        else if (ages[i] > second_oldest)
            second_oldest = ages[i];
    }

    result[0] = second_oldest;
    result[1] = oldest;
}

int main()
{
    int ages[] = {22, 42, 18, 42, 7};
    size_t n = sizeof(ages) / sizeof(ages[0]);
    int result[2];

    two_oldest_ages(n, ages, result);

    printf("Two oldest ages: %d, %d\n", result[0], result[1]);

    return 0;
}
