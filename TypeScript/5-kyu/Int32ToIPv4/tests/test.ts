import * as assert from 'assert';
import { int32ToIp } from '../Solutions';

assert.strictEqual(int32ToIp(2149583361), '128.32.10.1');

console.log('Int32ToIPv4 TS tests OK');
