"""
SumOfTwoLowestPositiveIntegers
Title: see docs/7-kyu/SumOfTwoLowestPositiveIntegers/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List

def sum_two_smallest_numbers(numbers: List[int]) -> int:
    """Return sum of the two smallest positive integers from the list."""
    positives = [n for n in numbers if n > 0]
    if len(positives) < 2:
        raise ValueError("Need at least two positive integers")
    min1 = min(positives)
    positives.remove(min1)
    min2 = min(positives)
    return min1 + min2
