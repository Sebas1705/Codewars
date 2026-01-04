const fs = require('fs');
const path = require('path');
const assert = require('assert');

function testModule(file) {
  try {
    const mod = require(path.resolve(file));
    if (mod.add) {
      assert.strictEqual(mod.add('123','456'), '579');
    }
    const ipfn = mod.int32ToIp || mod.int32_to_ip || mod.int32toip;
    if (ipfn) {
      assert.strictEqual(ipfn(2149583361), '128.32.10.1');
    }
    if (mod.rot13) {
      assert.strictEqual(mod.rot13('Hello, World!'), 'Uryyb, Jbeyq!');
    }
    // If a per-kata tests directory exists, require each test file (they should run assertions when required)
    const kataDir = path.dirname(path.resolve(file));
    const testsDir = path.join(kataDir, 'tests');
    if (fs.existsSync(testsDir) && fs.statSync(testsDir).isDirectory()){
      const tests = fs.readdirSync(testsDir).filter(x => x.endsWith('.js'));
      for (const t of tests){
        require(path.join(testsDir, t));
      }
    }
    console.log('OK', file);
  } catch (e) {
    console.error('FAIL', file, e && e.message);
    process.exitCode = 2;
  }
}

function walk(dir) {
  const items = fs.readdirSync(dir, { withFileTypes: true });
  for (const it of items) {
    const p = path.join(dir, it.name);
    if (it.isDirectory()) walk(p);
    else if (it.isFile() && it.name === 'Solutions.js') testModule(p);
  }
}

walk(path.join(__dirname));
