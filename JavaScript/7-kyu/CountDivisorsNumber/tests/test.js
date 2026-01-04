const assert = require('assert');
const { divisors } = require('../Solutions');

assert.strictEqual(divisors(4), 3); // 1,2,4
assert.strictEqual(divisors(5), 2);

console.log('CountDivisorsNumber tests OK');
