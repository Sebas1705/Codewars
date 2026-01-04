package p5_kyu_maximumsubarraysum

fun maxSequence(array: IntArray): Int {
    var maxSoFar = 0
    var maxEndingHere = 0
    for (v in array) {
        maxEndingHere += v
        if (maxEndingHere < 0) maxEndingHere = 0
        if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere
    }
    return maxSoFar
}

fun main() {
    val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println("Maximum subarray sum: ${maxSequence(array)}")
}
