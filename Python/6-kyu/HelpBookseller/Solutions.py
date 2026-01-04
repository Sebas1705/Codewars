"""
HelpBookseller
Title: see docs/6-kyu/HelpBookseller/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

from typing import List, Tuple

def stock_list(list_of_art: List[str], list_of_cat: List[str]) -> str:
    """Return formatted stock summary for bookseller kata."""
    if not list_of_art or not list_of_cat:
        return ""

    counts = {cat: 0 for cat in list_of_cat}
    for art in list_of_art:
        if not art: continue
        code, _, qty = art.rpartition(' ')
        if not qty.isdigit(): continue
        qty = int(qty)
        letter = art[0]
        for cat in list_of_cat:
            if cat and cat[0] == letter:
                counts[cat] += qty

    parts = [f"({cat} : {counts[cat]})" for cat in list_of_cat]
    return ' - '.join(parts)
