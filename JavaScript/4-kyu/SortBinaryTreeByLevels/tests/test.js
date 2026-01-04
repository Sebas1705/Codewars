const assert = require('assert');
const { Tree, treeByLevels } = require('../Solutions');

const t = new Tree(1, new Tree(2, new Tree(4), new Tree(5)), new Tree(3));
assert.deepStrictEqual(treeByLevels(t), [1,2,3,4,5]);

console.log('SortBinaryTreeByLevels tests OK');
