#!/usr/bin/env bash
set -euo pipefail
echo "Running Java compile check"
mkdir -p build/java_classes
files=$(find Java -name "*.java" -type f || true)
if [ -z "$files" ]; then
  echo "No Java sources found" && exit 0
fi
# compile all java sources
javac -d build/java_classes $files
echo "Java sources compiled successfully"

# Run any test classes found (classes whose name ends with Test)
tests=$(find build/java_classes -name "*Test.class" -type f -printf '%P\n' || true)
if [ -z "$tests" ]; then
  echo "No Java test classes found"
  exit 0
fi
for t in $tests; do
  cls=$(echo "$t" | sed 's/\.class$//' | sed 's|/|.|g')
  echo "Running Java test: $cls"
  if ! java -cp build/java_classes "$cls"; then
    echo "Java test $cls failed" >&2
    exit 1
  fi
done
echo "All Java tests ran OK"
