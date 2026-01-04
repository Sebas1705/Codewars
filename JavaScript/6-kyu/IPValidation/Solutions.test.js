try {
  const mod = require('./Solutions');
  if (mod.isValidIp) mod.isValidIp('127.0.0.1');
  console.log('TEST OK');
} catch (e) { console.error(e); process.exitCode = 2 }
