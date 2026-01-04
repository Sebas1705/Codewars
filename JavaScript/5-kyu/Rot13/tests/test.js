const assert = require('assert');
const { rot13 } = require('../Solutions');

assert.strictEqual(rot13('Hello, World!'), 'Uryyb, Jbeyq!');
assert.strictEqual(rot13('Uryyb'), 'Hello');

console.log('Rot13 tests OK');
