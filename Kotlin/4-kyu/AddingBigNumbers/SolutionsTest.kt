package kt_p4_addingbignumbers_test

import p4_kyu_addingbignumbers.add

fun main() {
    check(add("123", "456") == "579") { "AddingBigNumbers failed: 123+456" }
    check(add("999", "1") == "1000") { "AddingBigNumbers failed: 999+1" }
    println("AddingBigNumbers Kotlin tests OK")
}
