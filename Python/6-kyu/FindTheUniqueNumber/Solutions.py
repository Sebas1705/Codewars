"""
FindTheUniqueNumber
Title: see docs/6-kyu/FindTheUniqueNumber/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List

def find_unique(arr: List[int]) -> int:
    """Return the unique number in array where others are repeated."""
    from collections import Counter
    cnt = Counter(arr)
    for k, v in cnt.items():
        if v == 1:
            return k
    # fallback: try scanning (works even if values are floats)
    for x in arr:
        if sum(1 for y in arr if y == x) == 1:
            return x
    return 0
