import * as assert from 'assert';
import { add } from '../Solutions';

assert.strictEqual(add('123','456'), '579');
assert.strictEqual(add('999','1'), '1000');

console.log('AddingBigNumbers TS tests OK');
