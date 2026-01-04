package kt_p6_ipvalidation_test

import p6_kyu_ipvalidation.isValidIp

fun main() {
    check(isValidIp("192.168.1.1")) { "IPValidation failed for valid IP" }
    check(!isValidIp("192.0168.1.1")) { "IPValidation failed for leading zero" }
    println("IPValidation Kotlin tests OK")
}
