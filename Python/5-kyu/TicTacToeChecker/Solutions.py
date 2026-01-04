"""
TicTacToeChecker
Title: see docs/5-kyu/TicTacToeChecker/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List

def tic_tac_toe_checker(board: List[str]) -> str:
    """Return the winner of the tic-tac-toe board or 'Draw'/'Pending'."""
    # Accept board as list of 3 strings like ["XOX","OOX","XXO"]
    grid = []
    if len(board) == 0:
        return 'Draw'
    if isinstance(board[0], str):
        for row in board:
            grid.append(list(row))
    else:
        grid = [list(r) for r in board]

    def winner(ch: str) -> bool:
        # rows
        for i in range(3):
            if grid[i][0] == ch and grid[i][1] == ch and grid[i][2] == ch:
                return True
        # cols
        for j in range(3):
            if grid[0][j] == ch and grid[1][j] == ch and grid[2][j] == ch:
                return True
        # diags
        if grid[0][0] == ch and grid[1][1] == ch and grid[2][2] == ch:
            return True
        if grid[0][2] == ch and grid[1][1] == ch and grid[2][0] == ch:
            return True
        return False

    if winner('X'):
        return 'X'
    if winner('O'):
        return 'O'
    # check for empty
    for i in range(3):
        for j in range(3):
            if grid[i][j] == '' or grid[i][j] == ' ':
                return 'Pending'
    return 'Draw'
