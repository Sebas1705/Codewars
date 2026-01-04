const assert = require('assert');
const { checkGameState } = require('../Solutions');

const X = 1, O = 2, E = 0;
assert.strictEqual(checkGameState([[1,1,1],[0,2,0],[2,0,2]]), 1);
// draw board
assert.strictEqual(checkGameState([[1,2,1],[2,1,2],[2,1,2]]), 0);

console.log('TicTacToeChecker tests OK');
