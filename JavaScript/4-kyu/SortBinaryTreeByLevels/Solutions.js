class Tree {
    constructor(value, left=null, right=null) {
        this.value = value; this.left = left; this.right = right;
    }
}

function treeByLevels(tree) {
    if (!tree) return [];
    const q = [tree];
    const res = [];
    while (q.length) {
        const node = q.shift();
        res.push(node.value);
        if (node.left) q.push(node.left);
        if (node.right) q.push(node.right);
    }
    return res;
}

// ejemplo
const tree = new Tree(1, new Tree(2, new Tree(4), new Tree(5)), new Tree(3, new Tree(6), new Tree(7, new Tree(8))));
console.log(treeByLevels(tree));

module.exports = { Tree, treeByLevels };
