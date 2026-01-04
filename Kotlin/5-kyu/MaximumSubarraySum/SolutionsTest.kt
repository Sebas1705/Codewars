package kt_p5_maximumsubarraysum_test

import p5_kyu_maximumsubarraysum.maxSequence

fun main() {
    val arr = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    check(maxSequence(arr) == 6) { "MaximumSubarraySum failed" }
    println("MaximumSubarraySum Kotlin tests OK")
}
