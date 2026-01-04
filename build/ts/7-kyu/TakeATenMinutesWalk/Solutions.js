export function isValidWalk(walk) {
    if (!Array.isArray(walk))
        walk = String(walk).split('');
    if (walk.length !== 10)
        return false;
    let x = 0, y = 0;
    for (const c of walk) {
        if (c === 'n')
            y++;
        else if (c === 's')
            y--;
        else if (c === 'e')
            x++;
        else if (c === 'w')
            x--;
        else
            return false;
    }
    return x === 0 && y === 0;
}
