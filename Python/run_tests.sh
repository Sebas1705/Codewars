#!/usr/bin/env bash
set -euo pipefail
# Ejecuta la batería de tests de Python usando pytest
cd "$(dirname "$0")"

PY="python"
if [ -d ".venv" ]; then
  if [ -x ".venv/Scripts/python.exe" ]; then
    PY=".venv/Scripts/python.exe"
  elif [ -x ".venv/bin/python" ]; then
    PY=".venv/bin/python"
  fi
fi

echo "Running Python tests with pytest"
"$PY" -m pytest
