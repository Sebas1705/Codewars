import * as assert from 'assert';
import { rot13 } from '../Solutions';

assert.strictEqual(rot13('Hello, World!'), 'Uryyb, Jbeyq!');
assert.strictEqual(rot13('Uryyb'), 'Hello');

console.log('Rot13 TS tests OK');
