import * as assert from 'assert';
import { maxSequence } from '../Solutions';

assert.strictEqual(maxSequence([-2,1,-3,4,-1,2,1,-5,4]), 6);
assert.strictEqual(maxSequence([]), 0);

console.log('MaximumSubarraySum TS tests OK');
