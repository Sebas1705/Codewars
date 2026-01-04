export function findUniq(arr: number[]): number {
  const [a,b,c] = arr;
  let common = a === b || a === c ? a : b;
  if (a !== b && a !== c) return a;
  return arr.find(x => x !== common) as number;
}
