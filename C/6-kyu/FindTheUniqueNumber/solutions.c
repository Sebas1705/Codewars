#include <stdio.h>
#include <stddef.h>

float finduniq(const float nums[], size_t n)
{
    if (n == 0) return 0.0f;

    if (n >= 3) {
        float common;
        if (nums[0] == nums[1] || nums[0] == nums[2])
            common = nums[0];
        else
            common = nums[1];

        for (size_t i = 0; i < n; ++i)
            if (nums[i] != common)
                return nums[i];
    } else {
        /* For very small arrays, do a simple count */
        for (size_t i = 0; i < n; ++i) {
            size_t cnt = 0;
            for (size_t j = 0; j < n; ++j)
                if (nums[i] == nums[j]) ++cnt;
            if (cnt == 1) return nums[i];
        }
    }

    return 0.0f;
}

int main()
{
    float arr[] = { 1.0f, 1.0f, 1.0f, 2.0f, 1.0f };
    size_t n = sizeof(arr) / sizeof(arr[0]);
    float result = finduniq(arr, n);
    printf("The unique number is: %.1f\n", result);
    return 0;
}
