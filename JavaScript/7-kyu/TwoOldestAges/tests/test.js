const assert = require('assert');
const { twoOldestAges } = require('../Solutions');

assert.deepStrictEqual(twoOldestAges([1,5,87,45,8,8]), [45,87]);

console.log('TwoOldestAges tests OK');
