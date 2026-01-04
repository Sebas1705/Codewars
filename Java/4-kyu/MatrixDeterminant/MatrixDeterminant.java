public class MatrixDeterminant {
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        int det = 0;
        for (int col = 0; col < n; col++) {
            int[][] sub = new int[n-1][n-1];
            for (int i=1;i<n;i++){
                int sc = 0;
                for (int j=0;j<n;j++){
                    if (j==col) continue;
                    sub[i-1][sc++] = matrix[i][j];
                }
            }
            int subDet = determinant(sub);
            det += ((col%2==0)?1:-1) * matrix[0][col] * subDet;
        }
        return det;
    }

    public static void main(String[] args){
        int[][] m = {{2,4,2},{3,1,1},{1,2,0}};
        System.out.println("Determinant: " + determinant(m));
    }
}
