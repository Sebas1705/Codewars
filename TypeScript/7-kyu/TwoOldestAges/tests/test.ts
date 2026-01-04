import * as assert from 'assert';
import { twoOldestAges } from '../Solutions';

assert.deepStrictEqual(twoOldestAges([1,5,87,45,8,8]), [45,87]);

console.log('TwoOldestAges TS tests OK');
