"""
AddingBigNumbers
Title: see docs/4-kyu/AddingBigNumbers/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def add_big_numbers(a: str, b: str) -> str:
    """Return the sum of two arbitrarily large non-negative integers given as strings."""
    # Aprovechamos los enteros de precisión arbitraria de Python
    try:
        return str(int(a) + int(b))
    except ValueError:
        # Fallback: suma por dígitos si las entradas no son enteros válidos
        i, j = len(a) - 1, len(b) - 1
        carry = 0
        out = []
        while i >= 0 or j >= 0 or carry:
            da = ord(a[i]) - 48 if i >= 0 else 0
            db = ord(b[j]) - 48 if j >= 0 else 0
            s = da + db + carry
            out.append(chr((s % 10) + 48))
            carry = s // 10
            i -= 1; j -= 1
        return ''.join(reversed(out))
