fun twoOldestAges(ages: IntArray): IntArray {
    if (ages.size < 2) return intArrayOf()
    var oldest = Int.MIN_VALUE
    var secondOldest = Int.MIN_VALUE
    for (v in ages) {
        if (v > oldest) {
            secondOldest = oldest
            oldest = v
        } else if (v > secondOldest) {
            secondOldest = v
        }
    }
    return intArrayOf(secondOldest, oldest)
}

fun main() {
    val ages = intArrayOf(22, 42, 18, 42, 7)
    val result = twoOldestAges(ages)
    println("Two oldest ages: ${result[0]}, ${result[1]}")
}
