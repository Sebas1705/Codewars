const assert = require('assert');
const { add } = require('../Solutions');

assert.strictEqual(add('123','456'), '579');
assert.strictEqual(add('999','1'), '1000');

console.log('AddingBigNumbers tests OK');
