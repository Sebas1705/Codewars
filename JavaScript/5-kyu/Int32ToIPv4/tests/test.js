const assert = require('assert');
const { int32ToIp } = require('../Solutions');

assert.strictEqual(int32ToIp(2149583361), '128.32.10.1');

console.log('Int32ToIPv4 tests OK');
