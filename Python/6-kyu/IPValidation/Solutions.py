"""
IPValidation
Title: see docs/6-kyu/IPValidation/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def is_valid_ip(ip: str) -> bool:
    """Return True if `ip` is a valid IPv4 address."""
    if not ip or not isinstance(ip, str):
        return False
    parts = ip.split('.')
    if len(parts) != 4:
        return False
    for p in parts:
        if p == '':
            return False
        if any(c.isspace() for c in p):
            return False
        if not p.isdigit():
            return False
        if len(p) > 1 and p[0] == '0':
            return False
        val = int(p)
        if val < 0 or val > 255:
            return False
    return True
