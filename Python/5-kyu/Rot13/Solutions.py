"""
Rot13
Title: see docs/5-kyu/Rot13/title.md

"""

def rot13(text: str) -> str:
    """Apply ROT13 cipher to the given text."""
    import codecs
    return codecs.decode(text, 'rot_13')
