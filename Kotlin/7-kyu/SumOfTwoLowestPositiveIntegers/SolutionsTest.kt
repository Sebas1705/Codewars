package kt_p7_sumtwolowest_test

import p7_kyu_sumoftwolowestpositiveintegers.sumTwoSmallestNumbers

fun main() {
    val arr = intArrayOf(5, 8, 12, 18, 22)
    check(sumTwoSmallestNumbers(arr) == 13L) { "SumOfTwoLowestPositiveIntegers failed" }
    println("SumOfTwoLowestPositiveIntegers Kotlin tests OK")
}
