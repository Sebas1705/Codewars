"""
TakeATenMinutesWalk
Title: see docs/7-kyu/TakeATenMinutesWalk/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List

def is_valid_walk(walk: List[str]) -> bool:
    """Return True if walk brings you back in exactly ten minutes."""
    if len(walk) != 10:
        return False
    x = y = 0
    for step in walk:
        if step == 'n':
            y += 1
        elif step == 's':
            y -= 1
        elif step == 'e':
            x += 1
        elif step == 'w':
            x -= 1
        else:
            return False
    return x == 0 and y == 0
