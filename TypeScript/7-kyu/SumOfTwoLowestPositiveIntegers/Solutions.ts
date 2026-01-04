export function sumTwoSmallestNumbers(numbers: number[]): number {
  let min1 = Number.MAX_SAFE_INTEGER, min2 = Number.MAX_SAFE_INTEGER;
  for (const v of numbers) {
    if (v < min1) { min2 = min1; min1 = v; }
    else if (v < min2) min2 = v;
  }
  return min1 + min2;
}
