package kt_p4_countingchange_test

import p4_kyu_countingchangecombinations.countChange

fun main() {
    val coins = intArrayOf(5, 2, 3)
    check(countChange(10, coins.size, coins) == 4) { "CountingChangeCombinations failed" }
    println("CountingChangeCombinations Kotlin tests OK")
}
