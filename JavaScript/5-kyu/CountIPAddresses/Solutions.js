// CountIPAddresses - JavaScript
function ipToInt(ip){ return ip.split('.').reduce((acc,o)=> (acc<<8) + parseInt(o,10), 0) >>> 0; }
function ipsBetween(start, end){ return ipToInt(end) - ipToInt(start); }
module.exports = { ipsBetween };
