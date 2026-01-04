#!/usr/bin/env bash
set -euo pipefail
echo "Running Kotlin tests"
mkdir -p build/kotlin_classes
files=$(find Kotlin -name "*.kt" -type f || true)
if [ -z "$files" ]; then
  echo "No Kotlin sources found" && exit 0
fi

if ! command -v kotlinc >/dev/null 2>&1; then
  echo "kotlinc not found; skipping Kotlin tests (no compiler)"
  exit 0
fi

kotlinc -d build/kotlin_classes $files
echo "Kotlin compiled successfully"

# Ejecutar todas las clases que contengan la función main de tests
if command -v kotlin >/dev/null 2>&1; then
  tests=$(find build/kotlin_classes -name "SolutionsTestKt.class" -type f -printf '%P\n' || true)
  if [ -z "$tests" ]; then
    echo "No Kotlin test classes found"
    exit 0
  fi
  for t in $tests; do
    cls=$(echo "$t" | sed 's/\.class$//' | sed 's|/|.|g')
    echo "Running Kotlin test: $cls"
    if ! kotlin -cp build/kotlin_classes "$cls"; then
      echo "Kotlin test $cls failed" >&2
      exit 1
    fi
  done
  echo "All Kotlin tests ran OK"
else
  echo "kotlin runtime not found; compiled classes only"
fi
