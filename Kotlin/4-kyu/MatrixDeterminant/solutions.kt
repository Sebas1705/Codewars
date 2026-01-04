package p4_kyu_matrixdeterminant

fun determinant(matrix: Array<IntArray>): Int {
    val size = matrix.size
    if (size == 1) return matrix[0][0]
    if (size == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]

    var det = 0
    for (col in 0 until size) {
        val sub = Array(size - 1) { IntArray(size - 1) }
        for (i in 1 until size) {
            var subCol = 0
            for (j in 0 until size) {
                if (j == col) continue
                sub[i - 1][subCol++] = matrix[i][j]
            }
        }
        val subDet = determinant(sub)
        det += (if (col % 2 == 0) 1 else -1) * matrix[0][col] * subDet
    }
    return det
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(2, 4, 2),
        intArrayOf(3, 1, 1),
        intArrayOf(1, 2, 0)
    )
    println("Determinant: ${determinant(matrix)}")
}
