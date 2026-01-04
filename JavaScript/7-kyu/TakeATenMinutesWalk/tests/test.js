const assert = require('assert');
const { isValidWalk } = require('../Solutions');

assert.strictEqual(isValidWalk(['n','s','n','s','n','s','n','s','n','s']), true);
assert.strictEqual(isValidWalk(['n','n','n','n','n','n','n','n','n','n']), false);

console.log('TakeATenMinutesWalk tests OK');
