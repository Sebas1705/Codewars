"""
CountingChangeCombinations
Title: see docs/4-kyu/CountingChangeCombinations/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def count_change_combinations(amount: int, coins: list[int]) -> int:
    """Return number of ways to make `amount` using the given coin denominations."""
    # Use memoization to avoid exponential recursion
    coins = tuple(sorted(coins))
    from functools import lru_cache

    @lru_cache(maxsize=None)
    def ways(remaining: int, idx: int) -> int:
        if remaining == 0:
            return 1
        if remaining < 0 or idx < 0:
            return 0
        # include coin at idx or skip it
        return ways(remaining - coins[idx], idx) + ways(remaining, idx - 1)

    return ways(amount, len(coins) - 1)
