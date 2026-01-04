export function add(a: string, b: string): string {
  let i = a.length - 1, j = b.length - 1, carry = 0;
  let res = '';
  while (i >= 0 || j >= 0 || carry) {
    const da = i >= 0 ? Number(a[i--]) : 0;
    const db = j >= 0 ? Number(b[j--]) : 0;
    const s = da + db + carry;
    res = String(s % 10) + res;
    carry = Math.floor(s / 10);
  }
  return res;
}
