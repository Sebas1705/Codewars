package kt_p7_twooldestages_test

import p7_kyu_twooldestages.twoOldestAges

fun main() {
    val ages = intArrayOf(22, 42, 18, 42, 7)
    val res = twoOldestAges(ages)
    check(res[0] == 42 && res[1] == 42) { "TwoOldestAges failed" }
    println("TwoOldestAges Kotlin tests OK")
}
