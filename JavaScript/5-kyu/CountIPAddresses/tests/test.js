const assert = require('assert');
const { ipsBetween } = require('../Solutions');

assert.strictEqual(ipsBetween('10.0.0.0','10.0.0.50'), 50);
assert.strictEqual(ipsBetween('128.32.10.0','128.32.10.1'), 1);

console.log('CountIPAddresses tests OK');
