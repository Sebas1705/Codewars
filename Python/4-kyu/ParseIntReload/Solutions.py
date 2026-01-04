"""
ParseIntReload
Title: see docs/4-kyu/ParseIntReload/title.md

Placeholder Python solution module. Implement the function(s) required by the kata below.
"""

def parse_int_reload(text: str) -> int:
    """Parse a number given in English words and return its integer value."""
    units = {
        'zero':0,'one':1,'two':2,'three':3,'four':4,'five':5,'six':6,'seven':7,'eight':8,'nine':9
    }
    teens = {
        'ten':10,'eleven':11,'twelve':12,'thirteen':13,'fourteen':14,'fifteen':15,'sixteen':16,'seventeen':17,'eighteen':18,'nineteen':19
    }
    tens = {
        'twenty':20,'thirty':30,'forty':40,'fifty':50,'sixty':60,'seventy':70,'eighty':80,'ninety':90
    }

    result = 0
    current = 0

    for token in text.replace('-', ' ').split():
        token = token.lower()
        if token == 'and':
            continue
        if token in units:
            current += units[token]
        elif token in teens:
            current += teens[token]
        elif token in tens:
            current += tens[token]
        elif token == 'hundred':
            if current == 0:
                current = 1
            current *= 100
        elif token == 'thousand':
            if current == 0:
                current = 1
            current *= 1000
            result += current
            current = 0
        elif token == 'million':
            if current == 0:
                current = 1
            current *= 1000000
            result += current
            current = 0
        else:
            # unknown token
            pass

    return result + current
