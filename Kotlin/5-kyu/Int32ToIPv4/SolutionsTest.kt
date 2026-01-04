package kt_p5_int32toipv4_test

import p5_kyu_int32toipv4.uint32ToIp

fun main() {
    check(uint32ToIp(2_149_583_361) == "128.32.10.1") { "Int32ToIPv4 failed" }
    println("Int32ToIPv4 Kotlin tests OK")
}
