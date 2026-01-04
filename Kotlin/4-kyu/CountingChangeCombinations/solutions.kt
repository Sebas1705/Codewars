package p4_kyu_countingchangecombinations

fun countChange(money: Int, nCoins: Int, coins: IntArray): Int {
    if (money == 0) return 1
    if (money < 0 || nCoins == 0) return 0

    return countChange(money - coins[nCoins - 1], nCoins, coins) +
            countChange(money, nCoins - 1, coins)
}

fun main() {
    val coins = intArrayOf(5, 2, 3)
    val money = 10
    val ways = countChange(money, coins.size, coins)
    println("Number of ways to make change for $money: $ways")
}
