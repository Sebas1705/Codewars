"""
Rot13
Title: see docs/5-kyu/Rot13/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def rot13(text: str) -> str:
    """Apply ROT13 cipher to the given text."""
    import codecs
    return codecs.decode(text, 'rot_13')
