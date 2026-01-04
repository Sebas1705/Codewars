import * as assert from 'assert';
import { determinant } from '../Solutions';

assert.strictEqual(determinant([[2,4,2],[3,1,1],[1,2,0]]), 10);
assert.strictEqual(determinant([[1]]), 1);

console.log('MatrixDeterminant TS tests OK');
