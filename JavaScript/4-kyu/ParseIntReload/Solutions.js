function parseIntWords(number) {
  const units = { zero:0, one:1, two:2, three:3, four:4, five:5, six:6, seven:7, eight:8, nine:9 };
  const teens = { ten:10, eleven:11, twelve:12, thirteen:13, fourteen:14, fifteen:15, sixteen:16, seventeen:17, eighteen:18, nineteen:19 };
  const tens = { twenty:20, thirty:30, forty:40, fifty:50, sixty:60, seventy:70, eighty:80, ninety:90 };

  let result = 0, current = 0;
  const tokens = number.split(/[- ]/);
  for (const t0 of tokens) {
    const t = t0.trim();
    if (!t || t === 'and') continue;
    if (units[t] !== undefined) current += units[t];
    else if (teens[t] !== undefined) current += teens[t];
    else if (tens[t] !== undefined) current += tens[t];
    else if (t === 'hundred') { if (current === 0) current = 1; current *= 100; }
    else if (t === 'thousand') { if (current === 0) current = 1; current *= 1000; result += current; current = 0; }
    else if (t === 'million') { if (current === 0) current = 1; current *= 1000000; result += current; current = 0; }
  }
  return result + current;
}

console.log(parseIntWords('seven hundred eighty-three thousand nine hundred and nineteen'));

module.exports = { parseIntWords };
