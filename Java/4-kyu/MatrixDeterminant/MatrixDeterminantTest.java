public class MatrixDeterminantTest {
    public static void main(String[] args){
        int[][] m = {{2,4,2},{3,1,1},{1,2,0}};
        int d = MatrixDeterminant.determinant(m);
        if (d != 10) throw new RuntimeException("MatrixDeterminant test failed: got="+d);
        System.out.println("MatrixDeterminant: OK");
    }
}
