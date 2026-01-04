package p6_kyu_ipvalidation

fun isValidIp(addr: String?): Boolean {
    if (addr == null) return false
    if (addr.any { it.isWhitespace() }) return false

    val parts = addr.split('.')
    if (parts.size != 4) return false

    for (part in parts) {
        if (part.isEmpty()) return false
        if (part.length > 1 && part.startsWith('0')) return false
        if (!part.all { it.isDigit() }) return false
        val v = part.toIntOrNull() ?: return false
        if (v !in 0..255) return false
    }
    return true
}

fun main() {
    val testIp = "192.0168.1.1"
    println(if (isValidIp(testIp)) "$testIp is a valid IP address." else "$testIp is not a valid IP address.")
}
