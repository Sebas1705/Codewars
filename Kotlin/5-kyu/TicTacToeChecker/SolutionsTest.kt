package kt_p5_tictactoechecker_test

import p5_kyu_tictactoechecker.X
import p5_kyu_tictactoechecker.O
import p5_kyu_tictactoechecker.checkGameState
import p5_kyu_tictactoechecker.X_WON

fun main() {
    val board = arrayOf(
        intArrayOf(X, X, X),
        intArrayOf(0, O, O),
        intArrayOf(0, 0, 0)
    )
    check(checkGameState(board) == X_WON) { "TicTacToeChecker failed" }
    println("TicTacToeChecker Kotlin tests OK")
}
