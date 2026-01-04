import * as assert from 'assert';
import { checkGameState } from '../Solutions';

assert.strictEqual(checkGameState([[1,1,1],[0,2,0],[2,0,2]]), 1);
assert.strictEqual(checkGameState([[1,2,1],[2,1,2],[2,1,2]]), 0);

console.log('TicTacToeChecker TS tests OK');
