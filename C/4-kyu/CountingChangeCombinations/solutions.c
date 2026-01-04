#include <stdio.h>

int count_change(int money, int n_coins, const int coins[n_coins])
{
    if (money == 0)
        return 1;
    if (money < 0 || n_coins == 0)
        return 0;

    return count_change(money - coins[n_coins - 1], n_coins, coins) +
           count_change(money, n_coins - 1, coins);
}


int main()
{
    const int coins[] = {5,2,3};
    int money = 10;
    int ways = count_change(money, sizeof(coins) / sizeof(coins[0]), coins);
    printf("Number of ways to make change for %d: %d\n", money, ways);

    return 0;
}
