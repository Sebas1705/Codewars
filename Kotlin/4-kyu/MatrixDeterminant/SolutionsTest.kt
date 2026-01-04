package kt_p4_matrixdeterminant_test

import p4_kyu_matrixdeterminant.determinant

fun main() {
    val m = arrayOf(
        intArrayOf(2, 4, 2),
        intArrayOf(3, 1, 1),
        intArrayOf(1, 2, 0)
    )
    check(determinant(m) == 10) { "MatrixDeterminant failed" }
    println("MatrixDeterminant Kotlin tests OK")
}
