#include <stdio.h>
#include <stddef.h>

int determinant(size_t size, const int matrix[size][size]) 
{
    if (size == 1) 
        return matrix[0][0];
    if (size == 2)
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    
    int det = 0;
    for (size_t col = 0; col < size; col++) {
        int submatrix[size - 1][size - 1];
        for (size_t i = 1; i < size; i++) {
            size_t sub_col_index = 0;
            for (size_t j = 0; j < size; j++) {
                if (j == col) continue;
                submatrix[i - 1][sub_col_index] = matrix[i][j];
                sub_col_index++;
            }
        }
        int sub_det = determinant(size - 1, submatrix);
        det += (col % 2 == 0 ? 1 : -1) * matrix[0][col] * sub_det;
    }
    return det;
}

int main()
{
    const int matrix[3][3] = {
        {2, 4, 2},
        {3, 1, 1},
        {1, 2, 0}
    };
    int det = determinant(3, matrix);
    printf("Determinant: %d\n", det);
    return 0;
}
