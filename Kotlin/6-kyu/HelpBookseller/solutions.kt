fun stockSummary(books: Array<String>, categories: Array<String>): String {
    if (books.isEmpty() || categories.isEmpty()) return ""

    val counts = LongArray(categories.size)

    for (b in books) {
        if (b.isBlank()) continue
        val cat = b.first()
        val qty = b.substringAfterLast(' ').toLongOrNull() ?: continue
        for (j in categories.indices) {
            if (categories[j].firstOrNull() == cat) counts[j] += qty
        }
    }

    return categories.mapIndexed { j, c -> "(${c.first()} : ${counts[j]})" }.joinToString(" - ")
}

fun main() {
    val books = arrayOf("ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60")
    val categories = arrayOf("A", "B", "C", "D")
    println(stockSummary(books, categories))
}
