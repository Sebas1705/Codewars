package kt_p7_takeaten_test

import p7_kyu_takeatenminuteswalk.isValidWalk

fun main() {
    val good = "nsnsnsnsns"
    val bad = "nnnsnsnsns"
    check(isValidWalk(good)) { "TakeATenMinutesWalk failed for valid walk" }
    check(!isValidWalk(bad)) { "TakeATenMinutesWalk failed for invalid walk" }
    println("TakeATenMinutesWalk Kotlin tests OK")
}
