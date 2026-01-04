#include <stdio.h>

enum game_state {
    NOT_FINISHED = -1, DRAW = 0, X_WON = 1, O_WON = 2
};

enum square { EMPTY = 0, X = 1, O = 2 };

enum game_state check_game_state (const enum square board[3][3])
{
    int i, j;
    int x_won = 0, o_won = 0, empty_found = 0;

    // Check rows and columns
    for (i = 0; i < 3; i++) {
        if (board[i][0] == X && board[i][1] == X && board[i][2] == X)
            x_won = 1;
        if (board[i][0] == O && board[i][1] == O && board[i][2] == O)
            o_won = 1;
        if (board[0][i] == X && board[1][i] == X && board[2][i] == X)
            x_won = 1;
        if (board[0][i] == O && board[1][i] == O && board[2][i] == O)
            o_won = 1;
    }

    // Check diagonals
    if (board[0][0] == X && board[1][1] == X && board[2][2] == X)
        x_won = 1;
    if (board[0][0] == O && board[1][1] == O && board[2][2] == O)
        o_won = 1;
    if (board[0][2] == X && board[1][1] == X && board[2][0] == X)
        x_won = 1;
    if (board[0][2] == O && board[1][1] == O && board[2][0] == O)
        o_won = 1;

    // Check for empty squares
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            if (board[i][j] == EMPTY) {
                empty_found = 1;
                break;
            }
        }
        if (empty_found)
            break;
    }

    if (x_won)
        return X_WON;
    if (o_won)
        return O_WON;
    if (empty_found)
        return NOT_FINISHED;
    return DRAW;
}


int main()
{
    enum square board[3][3] = {
        {X, O, X},
        {O, X, O},
        {O, X, X}
    };
    enum game_state state = check_game_state(board);
    printf("Game state: %d\n", state); // Expected output: Game state: 1 (X_WON)
    return 0;
}
