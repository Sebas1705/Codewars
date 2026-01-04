// TicTacToeChecker - JavaScript
const NOT_FINISHED = -1, DRAW = 0, X_WON = 1, O_WON = 2;
function checkGameState(board){
  let xWon=false, oWon=false, emptyFound=false;
  for (let i=0;i<3;i++){
    if (board[i][0]===1 && board[i][1]===1 && board[i][2]===1) xWon=true;
    if (board[i][0]===2 && board[i][1]===2 && board[i][2]===2) oWon=true;
    if (board[0][i]===1 && board[1][i]===1 && board[2][i]===1) xWon=true;
    if (board[0][i]===2 && board[1][i]===2 && board[2][i]===2) oWon=true;
  }
  if (board[0][0]===1 && board[1][1]===1 && board[2][2]===1) xWon=true;
  if (board[0][0]===2 && board[1][1]===2 && board[2][2]===2) oWon=true;
  if (board[0][2]===1 && board[1][1]===1 && board[2][0]===1) xWon=true;
  if (board[0][2]===2 && board[1][1]===2 && board[2][0]===2) oWon=true;
  for (let i=0;i<3;i++) for (let j=0;j<3;j++) if (board[i][j]===0) { emptyFound=true; break; }
  if (xWon) return X_WON;
  if (oWon) return O_WON;
  if (emptyFound) return NOT_FINISHED;
  return DRAW;
}
module.exports = { checkGameState };
