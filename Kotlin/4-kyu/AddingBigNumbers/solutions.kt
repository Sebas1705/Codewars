fun add(a: String, b: String): String {
    val sb = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0

    while (i >= 0 || j >= 0 || carry > 0) {
        val da = if (i >= 0) a[i--].digitToInt() else 0
        val db = if (j >= 0) b[j--].digitToInt() else 0
        val sum = da + db + carry
        sb.append((sum % 10))
        carry = sum / 10
    }

    return sb.reverse().toString()
}

fun main() {
    println(add("1", "2"))
}
