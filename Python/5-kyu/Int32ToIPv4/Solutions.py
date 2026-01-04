"""
Int32ToIPv4
Title: see docs/5-kyu/Int32ToIPv4/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def int32_to_ipv4(int32: int) -> str:
    """Convert unsigned 32-bit integer to IPv4 dotted-quad string."""
    int32 &= 0xFFFFFFFF
    return f"{(int32 >> 24) & 0xFF}.{(int32 >> 16) & 0xFF}.{(int32 >> 8) & 0xFF}.{int32 & 0xFF}"
