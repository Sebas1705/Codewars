"""
TwoOldestAges
Title: see docs/7-kyu/TwoOldestAges/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List, Tuple

def two_oldest_ages(ages: List[int]) -> Tuple[int, int]:
    """Return the two oldest ages from the list as a tuple (older, second)."""
    if len(ages) < 2:
        raise ValueError("Need at least two ages")
    sorted_ages = sorted(ages, reverse=True)
    return (sorted_ages[0], sorted_ages[1])
