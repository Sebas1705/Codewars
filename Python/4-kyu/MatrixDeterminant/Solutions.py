"""
MatrixDeterminant
Title: see docs/4-kyu/MatrixDeterminant/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List

def matrix_determinant(matrix: List[List[int]]) -> int:
    """Compute and return determinant of a square matrix."""
    n = len(matrix)
    if n == 0:
        return 0
    if n == 1:
        return matrix[0][0]
    if n == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]

    def minor(mat, row, col):
        return [ [mat[i][j] for j in range(len(mat)) if j != col] for i in range(len(mat)) if i != row ]

    det = 0
    for col in range(n):
        sub = minor(matrix, 0, col)
        cofactor = ((-1) ** col) * matrix[0][col] * matrix_determinant(sub)
        det += cofactor
    return det
