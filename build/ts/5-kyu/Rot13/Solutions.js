export function rot13(src) {
    return src.replace(/[a-zA-Z]/g, c => {
        const code = c.charCodeAt(0);
        if (code >= 65 && code <= 90)
            return String.fromCharCode(65 + (code - 65 + 13) % 26);
        return String.fromCharCode(97 + (code - 97 + 13) % 26);
    });
}
