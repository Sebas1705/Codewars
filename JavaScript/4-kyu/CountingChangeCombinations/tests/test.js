const assert = require('assert');
const { countChange } = require('../Solutions');

assert.strictEqual(countChange(10, [5,2,3].length, [5,2,3]), 4);

console.log('CountingChangeCombinations tests OK');
