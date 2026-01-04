export class Tree {
    constructor(value, left = null, right = null) { this.value = value; this.left = left; this.right = right; }
}
export function treeByLevels(tree) {
    if (!tree)
        return [];
    const q = [tree];
    const res = [];
    while (q.length) {
        const node = q.shift();
        res.push(node.value);
        if (node.left)
            q.push(node.left);
        if (node.right)
            q.push(node.right);
    }
    return res;
}
