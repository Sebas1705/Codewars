fun uint32ToIp(number: Long): String {
    val b1 = (number shr 24) and 0xFF
    val b2 = (number shr 16) and 0xFF
    val b3 = (number shr 8) and 0xFF
    val b4 = number and 0xFF
    return "$b1.$b2.$b3.$b4"
}

fun main() {
    println(uint32ToIp(2149583361L)) // Expected: 128.32.10.1
}
