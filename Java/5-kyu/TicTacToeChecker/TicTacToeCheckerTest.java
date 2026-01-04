public class TicTacToeCheckerTest {
    public static void main(String[] args){
        int X = TicTacToeChecker.X;
        int O = TicTacToeChecker.O;
        int[][] board = {{X,X,X},{O,O,0},{0,0,0}};
        int state = TicTacToeChecker.checkGameState(board);
        if (state != TicTacToeChecker.X_WON) throw new RuntimeException("TicTacToeChecker test failed: got="+state);
        System.out.println("TicTacToeChecker: OK");
    }
}
