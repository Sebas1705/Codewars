fun parseIp(ip: String): Long {
    val parts = ip.split('.').map { it.toLong() }
    return (parts[0] shl 24) + (parts[1] shl 16) + (parts[2] shl 8) + parts[3]
}

fun ipsBetween(start: String, end: String): Long {
    val s = parseIp(start)
    val e = parseIp(end)
    return e - s
}

fun main() {
    val startIp = "20.0.0.10"
    val endIp = "20.0.1.0"
    println("Number of IPs between $startIp and $endIp: ${ipsBetween(startIp, endIp)}")
}
