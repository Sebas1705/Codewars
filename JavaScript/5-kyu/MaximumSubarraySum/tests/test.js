
const assert = require('assert');
const { maxSequence } = require('../Solutions');

assert.strictEqual(maxSequence([-2,1,-3,4,-1,2,1,-5,4]), 6);
assert.strictEqual(maxSequence([]), 0);

console.log('MaximumSubarraySum tests OK');
