fun rot13(src: String): String {
    val sb = StringBuilder()
    for (ch in src) {
        val c = when {
            ch in 'a'..'m' || ch in 'A'..'M' -> Char(ch.code + 13)
            ch in 'n'..'z' || ch in 'N'..'Z' -> Char(ch.code - 13)
            else -> ch
        }
        sb.append(c)
    }
    return sb.toString()
}

fun main() {
    val text = "Hello, World!"
    val encoded = rot13(text)
    println("Original: $text")
    println("Encoded: $encoded")
}
