import * as assert from 'assert';
import { findUniq } from '../Solutions';

assert.strictEqual(findUniq([1,1,1,2,1,1]), 2);
assert.strictEqual(findUniq([0,0,0.55,0,0]), 0.55);

console.log('FindTheUniqueNumber TS tests OK');
