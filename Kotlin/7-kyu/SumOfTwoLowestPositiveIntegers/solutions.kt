package p7_kyu_sumoftwolowestpositiveintegers

fun sumTwoSmallestNumbers(numbers: IntArray): Long {
    var min1 = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE
    for (v in numbers) {
        if (v < min1) {
            min2 = min1
            min1 = v
        } else if (v < min2) {
            min2 = v
        }
    }
    return min1.toLong() + min2.toLong()
}

fun main() {
    val arr = intArrayOf(2000000000, 2000000000, 2000000000, 2000000000, 2000000000)
    println("The sum of the two smallest positive integers is: ${sumTwoSmallestNumbers(arr)}")
}
