#!/usr/bin/env bash
set -euo pipefail
echo "Running C compile+run tests"
mkdir -p build/c_tests
found=0
for kata in C/*/*; do
  if [ -d "$kata" ]; then
    # find C source files excluding tests
    srcs=( $(find "$kata" -maxdepth 2 -name "*.c" -not -path "*/tests/*" -type f || true) )
    if [ ${#srcs[@]} -eq 0 ]; then
      continue
    fi
    found=1
    out="build/c_tests/$(echo "$kata" | sed 's|/|_|g').exe"
    echo "Compiling ${kata} -> $out"
    gcc -std=c99 -O2 -Wall -o "$out" ${srcs[@]} || { echo "Compile failed for $kata" >&2; exit 1; }
    echo "Running $out"
    if ! "$out"; then
      echo "Runtime failed for $kata" >&2
      exit 1
    fi
  fi
done
if [ "$found" -eq 0 ]; then
  echo "No C kata sources found" && exit 0
fi
echo "C compile+run tests passed"
