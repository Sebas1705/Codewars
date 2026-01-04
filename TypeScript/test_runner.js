const fs = require('fs');
const path = require('path');

function testModule(file) {
  try {
    const mod = require(path.resolve(file));
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
    if (it.isDirectory()) {
      // if a tests directory exists in build, run its JS files
      if (it.name === 'tests') {
        const tests = fs.readdirSync(p).filter(x => x.endsWith('.js'));
        for (const t of tests) testModule(path.join(p, t));
      }
      walk(p);
    } else if (it.isFile() && it.name === 'Solutions.js') testModule(p);
  }
}

const build = path.join(__dirname, '..', 'build', 'ts');
if (fs.existsSync(build)) walk(build);
