export class Tree {
  value: number; left: Tree | null; right: Tree | null;
  constructor(value: number, left: Tree | null = null, right: Tree | null = null) { this.value = value; this.left = left; this.right = right; }
}

export function treeByLevels(tree: Tree | null): number[] {
  if (!tree) return [];
  const q: (Tree|null)[] = [tree];
  const res: number[] = [];
  while (q.length) {
    const node = q.shift() as Tree;
    res.push(node.value);
    if (node.left) q.push(node.left);
    if (node.right) q.push(node.right);
  }
  return res;
}
