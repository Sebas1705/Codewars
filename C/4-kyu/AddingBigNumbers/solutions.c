#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *add(const char *a, const char *b) 
{
    int len_a = strlen(a);
    int len_b = strlen(b);
    int max_len = (len_a > len_b ? len_a : len_b) + 2; // +1 for possible carry, +1 for null terminator
    char *result = (char *)malloc(max_len);
    if (!result) return NULL;

    result[max_len - 1] = '\0';
    int carry = 0, i = len_a - 1, j = len_b - 1, k = max_len - 2;

    while (i >= 0 || j >= 0 || carry) {
        int digit_a = (i >= 0) ? a[i--] - '0' : 0;
        int digit_b = (j >= 0) ? b[j--] - '0' : 0;
        int sum = digit_a + digit_b + carry;
        result[k--] = (sum % 10) + '0';
        carry = sum / 10;
    }

    /* Move the result to the beginning of the allocated buffer so the
       returned pointer can be safely freed by the caller. */
    int start = k + 1;
    int res_len = max_len - start; /* includes terminating '\0' */
    memmove(result, result + start, res_len);
    return result; /* caller can free() this pointer */
}


int main()
{
    const char *num1 = "1";
    const char *num2 = "2";
    char *sum = add(num1, num2);
    printf("Sum: %s\n", sum);
    free(sum);

    return 0;
}
