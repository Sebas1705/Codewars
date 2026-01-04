package kt_p6_findtheuniquenumber_test

import p6_kyu_findtheuniquenumber.findUniq

fun main() {
    check(findUniq(floatArrayOf(1.0f,1.0f,1.0f,2.0f,1.0f,1.0f)) == 2.0f) { "FindTheUniqueNumber failed (2.0)" }
    check(findUniq(floatArrayOf(0.0f,0.0f,0.55f,0.0f,0.0f)) == 0.55f) { "FindTheUniqueNumber failed (0.55)" }
    println("FindTheUniqueNumber Kotlin tests OK")
}
