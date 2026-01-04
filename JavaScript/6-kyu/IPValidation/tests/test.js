const assert = require('assert');
const { isValidIp } = require('../Solutions');

if (!isValidIp('127.0.0.1')) throw new Error('127.0.0.1 should be valid');
if (isValidIp('abc')) throw new Error('abc should be invalid');
console.log('IPValidation JS: OK');
