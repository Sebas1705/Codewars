const val NOT_FINISHED = -1
const val DRAW = 0
const val X_WON = 1
const val O_WON = 2

const val EMPTY = 0
const val X = 1
const val O = 2

fun checkGameState(board: Array<IntArray>): Int {
    var xWon = false
    var oWon = false
    var emptyFound = false

    for (i in 0..2) {
        if (board[i][0] == X && board[i][1] == X && board[i][2] == X) xWon = true
        if (board[i][0] == O && board[i][1] == O && board[i][2] == O) oWon = true
        if (board[0][i] == X && board[1][i] == X && board[2][i] == X) xWon = true
        if (board[0][i] == O && board[1][i] == O && board[2][i] == O) oWon = true
    }

    if (board[0][0] == X && board[1][1] == X && board[2][2] == X) xWon = true
    if (board[0][0] == O && board[1][1] == O && board[2][2] == O) oWon = true
    if (board[0][2] == X && board[1][1] == X && board[2][0] == X) xWon = true
    if (board[0][2] == O && board[1][1] == O && board[2][0] == O) oWon = true

    loop@ for (i in 0..2) {
        for (j in 0..2) {
            if (board[i][j] == EMPTY) {
                emptyFound = true
                break@loop
            }
        }
    }

    return when {
        xWon -> X_WON
        oWon -> O_WON
        emptyFound -> NOT_FINISHED
        else -> DRAW
    }
}

fun main() {
    val board = arrayOf(
        intArrayOf(X, O, X),
        intArrayOf(O, X, O),
        intArrayOf(O, X, X)
    )
    println("Game state: ${checkGameState(board)}")
}
