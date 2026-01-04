public class TicTacToeChecker {
    public static final int NOT_FINISHED = -1, DRAW = 0, X_WON = 1, O_WON = 2;
    public static final int EMPTY=0, X=1, O=2;

    public static int checkGameState(int[][] board){
        boolean xWon=false,oWon=false,emptyFound=false;
        for (int i=0;i<3;i++){
            if (board[i][0]==X && board[i][1]==X && board[i][2]==X) xWon=true;
            if (board[i][0]==O && board[i][1]==O && board[i][2]==O) oWon=true;
            if (board[0][i]==X && board[1][i]==X && board[2][i]==X) xWon=true;
            if (board[0][i]==O && board[1][i]==O && board[2][i]==O) oWon=true;
        }
        if (board[0][0]==X && board[1][1]==X && board[2][2]==X) xWon=true;
        if (board[0][0]==O && board[1][1]==O && board[2][2]==O) oWon=true;
        if (board[0][2]==X && board[1][1]==X && board[2][0]==X) xWon=true;
        if (board[0][2]==O && board[1][1]==O && board[2][0]==O) oWon=true;
        outer: for (int i=0;i<3;i++) for (int j=0;j<3;j++) if (board[i][j]==EMPTY){ emptyFound=true; break outer; }
        if (xWon) return X_WON;
        if (oWon) return O_WON;
        if (emptyFound) return NOT_FINISHED;
        return DRAW;
    }

    public static void main(String[] args){
        int[][] board = {{X,O,X},{O,X,O},{O,X,X}};
        System.out.println("Game state: " + checkGameState(board));
    }
}
