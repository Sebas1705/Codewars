const assert = require('assert');
const { parseIntWords } = require('../Solutions');

assert.strictEqual(parseIntWords('seven hundred eighty-three thousand nine hundred and nineteen'), 783919);
assert.strictEqual(parseIntWords('one million'), 1000000);

console.log('ParseIntReload tests OK');
