"""
MaximumSubarraySum
Title: see docs/5-kyu/MaximumSubarraySum/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List

def max_subarray_sum(nums: List[int]) -> int:
    """Return the maximum sum of a contiguous subarray."""
    max_so_far = 0
    max_ending_here = 0
    for x in nums:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far
