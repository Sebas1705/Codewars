package kt_p7_countdivisors_test

import p7_kyu_countdivisorsnumber.divisors

fun main() {
    check(divisors(4L) == 3) { "CountDivisorsNumber failed for 4" }
    check(divisors(5L) == 2) { "CountDivisorsNumber failed for 5" }
    println("CountDivisorsNumber Kotlin tests OK")
}
