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
  (cd TypeScript && npm ci --no-audit --no-fund) >> "$report_file" 2>&1 || true
fi
if [ -f "JavaScript/package.json" ] && [ ! -d "JavaScript/node_modules" ]; then
  echo "Installing JavaScript dependencies" | tee -a "$report_file"
  (cd JavaScript && npm ci --no-audit --no-fund) >> "$report_file" 2>&1 || true
fi

# Run each runner if present
if [ -x "Python/run_tests.sh" ]; then
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
  run_and_log JavaScript node -e "const fs=require('fs'),p=require('path'); function test(f){try{const m=require(f); if(m.add&&m.add('123','456')!=='579')throw 1; if((m.int32ToIp||m.int32_to_ip)&&((m.int32ToIp||m.int32_to_ip)(2149583361)!=='128.32.10.1')) throw 1;}catch(e){console.error('JS FAIL',f,e); process.exitCode=2}}; function walk(d){for(const x of fs.readdirSync(d)){const fp=p.join(d,x); if(fs.statSync(fp).isDirectory()) walk(fp); else if(x==='Solutions.js') test(fp);} } walk('JavaScript'); console.log('JS runner done');"
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
    find "$lang" -mindepth 2 -maxdepth 3 -type d | while read -r kata; do
      # skip template
      if echo "$kata" | grep -q "template"; then continue; fi
      # heuristics for test presence
      has_test=0
      case "$lang" in
        Python)
          # global tests under Python/tests or per-kata tests
          if [ -d "Python/tests" ]; then has_test=1; fi
          ;;
        JavaScript)
          if ls "$kata"/*test*.js >/dev/null 2>&1 || [ -d "$kata/__tests__" ]; then has_test=1; fi
          ;;
        TypeScript)
          if ls "$kata"/*test*.ts >/dev/null 2>&1 || ls "$kata"/*spec*.ts >/dev/null 2>&1; then has_test=1; fi
          ;;
        Java)
          if ls "$kata"/*Test*.java >/dev/null 2>&1 || ls "$kata"/*Tests*.java >/dev/null 2>&1; then has_test=1; fi
          ;;
        C)
          # presence of solutions.c counts as source; check for tests folder
          if [ -d "$kata/tests" ] || ls "$kata"/*test*.c >/dev/null 2>&1; then has_test=1; fi
          ;;
        Kotlin)
          if ls "$kata"/*Test*.kt >/dev/null 2>&1; then has_test=1; fi
          ;;
      esac
      if [ "$has_test" -eq 0 ]; then
        echo "MISSING TEST: $lang/$kata" | tee -a "$report_file"
        missing=$((missing+1))
      fi
    done
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
