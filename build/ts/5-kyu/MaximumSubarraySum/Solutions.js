export function maxSequence(arr) {
    let maxSoFar = 0, maxEndingHere = 0;
    for (const v of arr) {
        maxEndingHere += v;
        if (maxEndingHere < 0)
            maxEndingHere = 0;
        if (maxSoFar < maxEndingHere)
            maxSoFar = maxEndingHere;
    }
    return maxSoFar;
}
