const assert = require('assert');
const { stockList } = require('../Solutions');

const lst = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"];
const cats = ["A","B","C","W"];
const res = stockList(lst, cats);
assert.strictEqual(res, "(A : 20) - (B : 114) - (C : 50) - (W : 0)");

console.log('HelpBookseller tests OK');
