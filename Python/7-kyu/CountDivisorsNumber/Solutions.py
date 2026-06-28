"""
CountDivisorsNumber
Title: see docs/7-kyu/CountDivisorsNumber/title.md

"""

def count_divisors(n: int) -> int:
    """Return number of divisors of n."""
    if n <= 0:
        return 0
    count = 0
    i = 1
    while i * i <= n:
        if n % i == 0:
            count += 1
            if i != n // i:
                count += 1
        i += 1
    return count
