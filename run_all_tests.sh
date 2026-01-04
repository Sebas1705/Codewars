#!/usr/bin/env bash
set -euo pipefail
echo "Run all language test runners and verify test coverage per kata"

ROOT=$(pwd)

report_file="build/test_report.txt"
mkdir -p build
echo "Test run at $(date)" > "$report_file"

run_and_log(){
  lang=$1; shift
  cmd=$@
  echo "--- $lang tests ---" | tee -a "$report_file"
  if eval "$cmd" >> "$report_file" 2>&1; then
    echo "$lang: OK" | tee -a "$report_file"
  else
    echo "$lang: FAILED (see $report_file)" | tee -a "$report_file"
  fi
}

# Prepare Python venv
if [ ! -d "Python/.venv" ]; then
  echo "Creating Python venv in Python/.venv" | tee -a "$report_file"
  python -m venv Python/.venv
fi
if [ -f "Python/requirements.txt" ]; then
  echo "Installing Python requirements..." | tee -a "$report_file"
  Python/.venv/Scripts/python.exe -m pip install -q -r Python/requirements.txt
fi

# Prepare Node/TypeScript envs
if [ -f "TypeScript/package.json" ] && [ ! -d "TypeScript/node_modules" ]; then
  echo "Installing TypeScript dependencies" | tee -a "$report_file"
  if [ -f "TypeScript/package-lock.json" ]; then
    (cd TypeScript && npm ci --no-audit --no-fund) >> "$report_file" 2>&1 || true
  else
    (cd TypeScript && npm install --no-audit --no-fund) >> "$report_file" 2>&1 || true
  fi
fi
if [ -f "JavaScript/package.json" ] && [ ! -d "JavaScript/node_modules" ]; then
  echo "Installing JavaScript dependencies" | tee -a "$report_file"
  if [ -f "JavaScript/package-lock.json" ]; then
    (cd JavaScript && npm ci --no-audit --no-fund) >> "$report_file" 2>&1 || true
  else
    (cd JavaScript && npm install --no-audit --no-fund) >> "$report_file" 2>&1 || true
  fi
fi

# Run each runner if present
if [ -f "Python/run_tests.sh" ]; then
  run_and_log Python bash Python/run_tests.sh
fi
if [ -x "TypeScript/run_tests.sh" ]; then
  # ensure TS compiled if tsc present
  if [ -f "TypeScript/node_modules/.bin/tsc" ]; then
    echo "Compiling TypeScript sources" | tee -a "$report_file"
    (cd TypeScript && node node_modules/.bin/tsc --project . || node node_modules/.bin/tsc) >> "$report_file" 2>&1 || true
  fi
  run_and_log TypeScript bash TypeScript/run_tests.sh
fi
if [ -d "JavaScript" ]; then
  # Prefer centralized runner to avoid shell quoting issues
  if [ -f "js_inline_runner.js" ]; then
    run_and_log JavaScript node js_inline_runner.js
  elif [ -f "JavaScript/test_runner.js" ]; then
    run_and_log JavaScript node JavaScript/test_runner.js
  else
    echo "JavaScript: no runner found" | tee -a "$report_file"
  fi
fi
if [ -x "C/run_tests.sh" ]; then
  run_and_log C bash C/run_tests.sh
fi
if [ -x "Java/run_tests.sh" ]; then
  run_and_log Java bash Java/run_tests.sh
fi
if [ -x "Kotlin/run_tests.sh" ]; then
  run_and_log Kotlin bash Kotlin/run_tests.sh || true
fi

echo "
Verifying test files exist per language and kata" | tee -a "$report_file"
missing=0
# Languages and their kata folders
for lang in Python JavaScript TypeScript Java C Kotlin; do
  if [ -d "$lang" ]; then
    echo "Checking $lang..." | tee -a "$report_file"
    while IFS= read -r kata; do
      # skip template
      if echo "$kata" | grep -q "template"; then continue; fi
        # heuristics for test presence
        has_test=0
        # strip leading language prefix from kata path for nicer output and build lookups
        kata_rel=${kata#${lang}/}
        case "$lang" in
          Python)
            if [ -d "Python/tests" ] || find "$kata" -type f -name '*test*.py' -print -quit | grep -q .; then has_test=1; fi
            ;;
          JavaScript)
            if find "$kata" -type f \( -name '*test*.js' -o -name '*spec*.js' \) -print -quit | grep -q .; then has_test=1; fi
            # also accept compiled TS tests under build/ts
            if [ -f "build/ts/$kata_rel/tests/test.js" ] || [ -d "build/ts/$kata_rel/tests" ]; then has_test=1; fi
            ;;
          TypeScript)
            if find "$kata" -type f \( -name '*test*.ts' -o -name '*spec*.ts' \) -print -quit | grep -q .; then has_test=1; fi
            if [ -d "build/ts/$kata_rel/tests" ] || [ -f "build/ts/$kata_rel/Solutions.js" ]; then has_test=1; fi
            ;;
          Java)
            if find "$kata" -type f -name '*Test*.java' -print -quit | grep -q .; then has_test=1; fi
            ;;
          C)
            if [ -d "$kata/tests" ] || [ -d "$kata/src/tests" ] || find "$kata" -type f -name '*test*.c' -print -quit | grep -q .; then has_test=1; fi
            # built C binaries created by C runner
            bin_name=$(echo "$kata" | sed 's|/|_|g').exe
            if [ -f "build/c_tests/$bin_name" ]; then has_test=1; fi
            ;;
          Kotlin)
            if find "$kata" -type f -name '*Test*.kt' -print -quit | grep -q .; then has_test=1; fi
            ;;
        esac
        if [ "$has_test" -eq 0 ]; then
          echo "MISSING TEST: $lang/$kata_rel" | tee -a "$report_file"
          missing=$((missing+1))
        fi
    done < <(find "$lang" -mindepth 2 -maxdepth 2 -type d -not -path "*/node_modules/*" -not -path "*/node_modules")
  fi
done

echo "
Summary:" | tee -a "$report_file"
if [ "$missing" -eq 0 ]; then
  echo "All kata directories have at least one heuristic test indicator." | tee -a "$report_file"
else
  echo "$missing kata folders missing tests (heuristic)." | tee -a "$report_file"
fi

echo "Full log: $report_file"
