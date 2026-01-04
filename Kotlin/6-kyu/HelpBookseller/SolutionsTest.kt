package kt_p6_helpbookseller_test

import p6_kyu_helpbookseller.stockSummary

fun main() {
    val books = arrayOf("ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60")
    val cats = arrayOf("A", "B", "C", "W")
    val res = stockSummary(books, cats)
    check(res == "(A : 20) - (B : 114) - (C : 50) - (W : 0)") { "HelpBookseller failed" }
    println("HelpBookseller Kotlin tests OK")
}
