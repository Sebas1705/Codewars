import * as assert from 'assert';
import { isValidWalk } from '../Solutions';

assert.strictEqual(isValidWalk(['n','s','n','s','n','s','n','s','n','s']), true);
assert.strictEqual(isValidWalk(['n','n','n','n','n','n','n','n','n','n']), false);

console.log('TakeATenMinutesWalk TS tests OK');
