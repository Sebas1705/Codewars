#!/usr/bin/env bash
set -euo pipefail
echo "Running TypeScript tests"
# run the packaged test runner which inspects build/ts
node TypeScript/test_runner.js
