"""
SortBinaryTreeByLevels
Title: see docs/4-kyu/SortBinaryTreeByLevels/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import Optional, List

class Node:
    def __init__(self, value: int, left: Optional['Node']=None, right: Optional['Node']=None):
        self.value = value
        self.left = left
        self.right = right

def tree_by_levels(root: Optional[Node]) -> List[int]:
    """Return level-order traversal values of the binary tree."""
    from collections import deque
    if root is None:
        return []
    q = deque([root])
    out = []
    while q:
        node = q.popleft()
        out.append(node.value)
        if node.left:
            q.append(node.left)
        if node.right:
            q.append(node.right)
    return out
