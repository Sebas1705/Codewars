fun divisors(n: Long): Int {
    var count = 0
    val limit = kotlin.math.sqrt(n.toDouble()).toLong()
    for (i in 1L..limit) {
        if (n % i == 0L) {
            count++
            if (i != n / i) count++
        }
    }
    return count
}

fun main() {
    val number = 36L
    println("Number of divisors of $number is ${divisors(number)}")
}
