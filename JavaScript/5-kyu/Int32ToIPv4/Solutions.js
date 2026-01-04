// Int32ToIPv4 - JavaScript
function int32ToIp(num){
  num = Number(num) >>> 0;
  return ((num >>> 24) & 0xFF) + "." + ((num >>> 16) & 0xFF) + "." + ((num >>> 8) & 0xFF) + "." + (num & 0xFF);
}
module.exports = { int32ToIp };
