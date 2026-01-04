package kt_p5_countipaddresses_test

import p5_kyu_countipaddresses.ipsBetween

fun main() {
    check(ipsBetween("20.0.0.10", "20.0.1.0") == 246L) { "CountIPAddresses failed" }
    println("CountIPAddresses Kotlin tests OK")
}
