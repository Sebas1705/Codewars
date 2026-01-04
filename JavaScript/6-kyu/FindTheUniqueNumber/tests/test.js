const assert = require('assert');
const { findUniq } = require('../Solutions');

assert.strictEqual(findUniq([1,1,1,2,1,1]), 2);
assert.strictEqual(findUniq([0,0,0.55,0,0]), 0.55);

console.log('FindTheUniqueNumber tests OK');
