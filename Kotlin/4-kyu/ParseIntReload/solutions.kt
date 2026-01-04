fun parseInt(number: String): Long {
    val units = mapOf(
        "zero" to 0L, "one" to 1L, "two" to 2L, "three" to 3L, "four" to 4L,
        "five" to 5L, "six" to 6L, "seven" to 7L, "eight" to 8L, "nine" to 9L
    )
    val teens = mapOf(
        "ten" to 10L, "eleven" to 11L, "twelve" to 12L, "thirteen" to 13L,
        "fourteen" to 14L, "fifteen" to 15L, "sixteen" to 16L, "seventeen" to 17L,
        "eighteen" to 18L, "nineteen" to 19L
    )
    val tens = mapOf(
        "twenty" to 20L, "thirty" to 30L, "forty" to 40L, "fifty" to 50L,
        "sixty" to 60L, "seventy" to 70L, "eighty" to 80L, "ninety" to 90L
    )

    var result = 0L
    var current = 0L

    val tokens = number.split(' ', '-')
    for (t in tokens) {
        if (t.isBlank() || t == "and") continue
        when {
            units.containsKey(t) -> current += units[t]!!
            teens.containsKey(t) -> current += teens[t]!!
            tens.containsKey(t) -> current += tens[t]!!
            t == "hundred" -> {
                if (current == 0L) current = 1L
                current *= 100L
            }
            t == "thousand" -> {
                if (current == 0L) current = 1L
                current *= 1000L
                result += current
                current = 0L
            }
            t == "million" -> {
                if (current == 0L) current = 1L
                current *= 1_000_000L
                result += current
                current = 0L
            }
        }
    }

    result += current
    return result
}

fun main() {
    println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"))
}
