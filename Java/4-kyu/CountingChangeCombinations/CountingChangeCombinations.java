public class CountingChangeCombinations {
    public static int countChange(int money, int nCoins, int[] coins) {
        if (money == 0) return 1;
        if (money < 0 || nCoins == 0) return 0;
        return countChange(money - coins[nCoins - 1], nCoins, coins)
                + countChange(money, nCoins - 1, coins);
    }

    public static void main(String[] args) {
        int[] coins = {5,2,3};
        System.out.println(countChange(10, coins.length, coins));
    }
}
