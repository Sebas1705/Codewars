package p7_kyu_takeatenminuteswalk

fun isValidWalk(walk: String): Boolean {
    if (walk.length != 10) return false
    var x = 0
    var y = 0
    for (ch in walk) {
        when (ch) {
            'n' -> y++
            's' -> y--
            'e' -> x++
            'w' -> x--
            else -> return false
        }
    }
    return x == 0 && y == 0
}

fun main() {
    val walk = "nsnsnsnsns"
    println(if (isValidWalk(walk)) "Valid walk" else "Invalid walk")
}
