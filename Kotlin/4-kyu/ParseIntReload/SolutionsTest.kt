package kt_p4_parseintreload_test

import p4_kyu_parseintreload.parseInt

fun main() {
    val s = "seven hundred eighty-three thousand nine hundred and nineteen"
    check(parseInt(s) == 783_919L) { "ParseIntReload failed" }
    println("ParseIntReload Kotlin tests OK")
}
