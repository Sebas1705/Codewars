export function divisors(n) {
    let count = 0;
    const limit = Math.floor(Math.sqrt(n));
    for (let i = 1; i <= limit; i++) {
        if (n % i === 0) {
            count++;
            if (i !== n / i)
                count++;
        }
    }
    return count;
}
