export function ipToInt(ip) {
    return ip.split('.').reduce((acc, o) => ((acc << 8) + parseInt(o, 10)) >>> 0, 0) >>> 0;
}
export function ipsBetween(start, end) {
    return ipToInt(end) - ipToInt(start);
}
