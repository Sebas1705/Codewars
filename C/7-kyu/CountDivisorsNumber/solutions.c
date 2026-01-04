#include <stdio.h>

int divisors(long long n)
{
    int count = 0;
    for (long long i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            count++;
            if (i != n / i) {
                count++;
            }
        }
    }
    return count;
}

int main()
{
    long long number = 36;
    int result = divisors(number);

    printf("Number of divisors of %lld is %d\n", number, result);

    return 0;
}
