<div align="center">

# Codewars Multi‑Language Katas

**17 katas** solved in **6 languages** — same problem, different solutions.

`C` · `Java` · `Kotlin` · `JavaScript` · `TypeScript` · `Python`

</div>

---

## What this is

Each kata in this repo is solved in all 6 languages using a consistent structure and test suite. The goal is not just to solve the problem — it's to see how different languages express the same algorithm: how Kotlin's functional style differs from C's pointer arithmetic, or how Python's readability trades off against TypeScript's type safety.

Katas range from **4-kyu** (hard — recursion, dynamic programming, data structures) to **7-kyu** (easier — string/number manipulation). Every solution has tests.

---

## Kata Catalogue

| Difficulty | Kata | Topic | Description |
|---|---|---|---|
| 4-kyu | AddingBigNumbers | String arithmetic | Sum arbitrarily large numbers given as strings — without BigInt |
| 4-kyu | CountingChangeCombinations | Dynamic programming | Count the number of ways to make change for a given amount |
| 4-kyu | MatrixDeterminant | Recursion / linear algebra | Compute the determinant of an N×N matrix using cofactor expansion |
| 4-kyu | ParseIntReload | String parsing | Parse integer from its English word representation ("one hundred" → 100) |
| 4-kyu | SortBinaryTreeByLevels | BFS / trees | Level-order traversal of a binary tree, returning values grouped by depth |
| 5-kyu | CountIPAddresses | Bit manipulation | Count valid IPv4 addresses between two given addresses |
| 5-kyu | Int32ToIPv4 | Bit manipulation | Convert a 32-bit integer to its dotted IPv4 string representation |
| 5-kyu | MaximumSubarraySum | Dynamic programming | Kadane's algorithm — find the maximum sum of a contiguous subarray |
| 5-kyu | Rot13 | String / ciphers | Apply ROT13 Caesar cipher to a string |
| 5-kyu | TicTacToeChecker | 2D arrays / game logic | Determine the winner (or lack thereof) of a Tic-Tac-Toe board |
| 6-kyu | FindTheUniqueNumber | Hashing / XOR | Find the single element in an array where all others appear twice |
| 6-kyu | HelpBookseller | String processing | Aggregate and format stock data from a space-separated string |
| 6-kyu | IPValidation | Regex / parsing | Validate whether a string is a valid IPv4 address |
| 7-kyu | CountDivisorsNumber | Number theory | Count the number of divisors of an integer |
| 7-kyu | SumOfTwoLowestPositiveIntegers | Sorting | Find and sum the two smallest positive integers in an array |
| 7-kyu | TakeATenMinutesWalk | Arrays / direction | Verify that a walk described as directions returns to the origin in exactly 10 min |
| 7-kyu | TwoOldestAges | Sorting | Return the two largest values from an array of ages |

---

## Repository Structure

```text
.
├─ C/
├─ Java/
├─ JavaScript/
├─ Kotlin/
├─ Python/
├─ TypeScript/
├─ docs/
└─ run_all_tests.sh
```

- `docs/` – Problem catalogue and titles per kata.
  - `docs/problems_index.json` – Single source of truth for all katas (kyu, name, languages, title path).
  - `docs/<kyu>/<KataName>/title.md` – Human‑readable kata description/title.
- `<Language>/<kyu>/<KataName>/` – Solutions (and in some languages, per‑kata tests).
- `build/` – Compiled artifacts and aggregated test report (`build/test_report.txt`).
- `run_all_tests.sh` – Top‑level script that prepares environments and runs all language test suites.

Kyu levels mirror Codewars:

- `4-kyu` – harder katas
- `5-kyu`
- `6-kyu`
- `7-kyu` – easier katas

---

## Katas Catalogue

The master index is [docs/problems_index.json](docs/problems_index.json). Each entry exposes:

- `kyu` – Difficulty level (e.g. `"4-kyu"`).
- `kata` – Canonical kata name.
- `languages` – Languages in which the kata is implemented.
- `title_path` – Path to the kata title/description under `docs/`.

Example entry:

```jsonc
{
  "kyu": "5-kyu",
  "kata": "Rot13",
  "languages": ["C", "Kotlin", "Java", "JavaScript", "TypeScript", "Python"],
  "title_path": "docs/5-kyu/Rot13/title.md"
}
```

Every language directory mirrors this structure, so the path pattern is consistent:

```text
<Language>/<kyu>/<KataName>/
```

---

## Testing & Tooling

### Global Test Runner

To verify all languages and katas at once, run from the repository root:

```bash
bash run_all_tests.sh
```

This script will:\r

1. Prepare environments:
	- Create a Python virtualenv under `Python/.venv` and install `Python/requirements.txt`.
	- Install npm dependencies for `JavaScript/` and `TypeScript/`.
2. Run each language runner (if available):
	- Python – `bash Python/run_tests.sh`
	- TypeScript – `bash TypeScript/run_tests.sh`
	- JavaScript – `node JavaScript/test_runner.js`
	- C – `bash C/run_tests.sh`
	- Java – `bash Java/run_tests.sh`
	- Kotlin – `bash Kotlin/run_tests.sh`
3. Append a summary and per‑language status to `build/test_report.txt`.
4. Heuristically check that **every kata directory for every language has at least one test indicator** (central test file, per‑kata tests, or compiled test artifact).

> On Windows, run the script from Git Bash or WSL for best results:
>
> ```bash
> cd /c/Users/<you>/Documents/Codewars
> bash run_all_tests.sh
> ```

### Language‑Specific Notes

#### Python

- Solutions live under `Python/<kyu>/<KataName>/Solutions.py`.
- Central tests: [Python/tests/test_solutions.py](Python/tests/test_solutions.py) uses `unittest` to import each kata’s `Solutions.py` and exercise the main functions.
- Runner: [Python/run_tests.sh](Python/run_tests.sh) selects the virtualenv interpreter (if present) and executes:

  ```bash
  python -m pytest
  ```

#### JavaScript

- Solutions: `JavaScript/<kyu>/<KataName>/Solutions.js`.
- Per‑kata tests: optional `tests/test.js` under each kata, using Node’s `assert` module.
- Central runner: [JavaScript/test_runner.js](JavaScript/test_runner.js) which:
  - Requires each `Solutions.js`.
  - Runs built‑in smoke tests for common functions.
  - Automatically executes any `tests/*.js` files alongside the solution.

#### TypeScript

- Source: `TypeScript/<kyu>/<KataName>/Solutions.ts` (+ optional `tests/test.ts`).
- Compiled output: `build/ts/...` (generated by `tsc`).
- Runner: [TypeScript/test_runner.js](TypeScript/test_runner.js) walks `build/ts`, requires each `Solutions.js`, and runs compiled test files under `tests/`.

#### C

- Layout per kata: `C/<kyu>/<KataName>/solutions.c` + `src/`.
- Runner: [C/run_tests.sh](C/run_tests.sh) compiles each kata into `build/c_tests/<Kata>.exe` and executes it.
- Any previous empty `tests/` folders were removed to avoid placeholder noise; the executable itself acts as the kata test harness.

#### Java

- Source: `Java/<kyu>/<KataName>/*.java`.
- Runner: [Java/run_tests.sh](Java/run_tests.sh) compiles everything into `build/java_classes` and runs every `*Test` class it finds.
- Each kata has at least one dedicated `*Test.java` that exercises the kata’s public API.

#### Kotlin

- Source: `Kotlin/<kyu>/<KataName>/solutions.kt`.
- Tests: `Kotlin/<kyu>/<KataName>/SolutionsTest.kt` (one per kata).
- Runner: [Kotlin/run_tests.sh](Kotlin/run_tests.sh) compiles to `build/kotlin_classes` and executes all `SolutionsTestKt` classes via `kotlin -cp ...`.
- All former "TEST OK" placeholders were replaced with **real assertions** that:
  - Import the corresponding solution function(s).
  - Validate expected outputs for representative inputs.

---

## Adding a New Kata

1. **Update the index**
	- Add an entry to [docs/problems_index.json](docs/problems_index.json) with `kyu`, `kata`, `languages`, and `title_path`.
2. **Add the title/description**
	- Create `docs/<kyu>/<KataName>/title.md` with the kata title and a short description.
3. **Create solution skeletons**
	- For each language in `languages`, add:

	  ```text
	  <Language>/<kyu>/<KataName>/Solutions.*
	  ```

4. **Add tests**
	- Python: extend [Python/tests/test_solutions.py](Python/tests/test_solutions.py).
	- JS/TS: add `tests/test.(js|ts)` next to `Solutions`.
	- C: ensure `solutions.c` (or a dedicated test file) prints/validates expected results.
	- Java: create a `*Test.java` class for the kata.
	- Kotlin: create or update `SolutionsTest.kt` with `check(...)` based assertions.
5. **Run the full test suite**
	- Execute `bash run_all_tests.sh` and confirm all languages are `OK` and no kata is reported as missing tests.

---

## Requirements

To run the full test pipeline you will typically need:

- Python 3.x
- Node.js + npm
- A C compiler (e.g. `gcc`)
- Java JDK (for `javac` and `java`)
- Kotlin compiler (`kotlinc`) and runtime (`kotlin`)

You can still work language‑by‑language if some toolchains are missing; `run_all_tests.sh` will skip runners that cannot be executed.

---

## License

This repository is distributed under the terms of the [LICENSE](LICENSE) file.

