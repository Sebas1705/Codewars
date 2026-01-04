// IPValidation - JavaScript
function isValidIp(addr){
  if (typeof addr !== 'string') return false;
  if (/\s/.test(addr)) return false;
  const parts = addr.split('.');
  if (parts.length !== 4) return false;
  for (const p of parts){
    if (p.length === 0) return false;
    if (p.length > 1 && p[0] === '0') return false;
    if (!/^\d+$/.test(p)) return false;
    const v = Number(p);
    if (v < 0 || v > 255) return false;
  }
  return true;
}
module.exports = { isValidIp };
