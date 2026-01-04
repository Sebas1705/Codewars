export function ipToInt(ip: string): number {
  return ip.split('.').reduce((acc, o) => ((acc << 8) + parseInt(o, 10)) >>> 0, 0) >>> 0;
}

export function ipsBetween(start: string, end: string): number {
  return ipToInt(end) - ipToInt(start);
}
