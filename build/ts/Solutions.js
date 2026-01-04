"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.add = add;
function add(a, b) {
    var i = a.length - 1, j = b.length - 1, carry = 0;
    var res = '';
    while (i >= 0 || j >= 0 || carry) {
        var da = i >= 0 ? Number(a[i--]) : 0;
        var db = j >= 0 ? Number(b[j--]) : 0;
        var s = da + db + carry;
        res = String(s % 10) + res;
        carry = Math.floor(s / 10);
    }
    return res;
}
