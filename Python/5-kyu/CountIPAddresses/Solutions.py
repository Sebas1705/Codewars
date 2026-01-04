"""
CountIPAddresses
Title: see docs/5-kyu/CountIPAddresses/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def count_ip_addresses(start: str, end: str) -> int:
    """Return number of IPv4 addresses between `start` and `end` (inclusive/exclusive as per kata)."""
    def ip_to_int(ip: str) -> int:
        parts = [int(p) for p in ip.split('.')]
        return (parts[0] << 24) | (parts[1] << 16) | (parts[2] << 8) | parts[3]

    return ip_to_int(end) - ip_to_int(start)
