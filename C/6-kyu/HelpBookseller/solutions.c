#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *stockSummary(
    const char *const books[/* n_books */], size_t n_books,
	const char *const categories[/* n_categories */], size_t n_categories
) {
    if (n_books == 0 || n_categories == 0) {
        return calloc(1, 1);
    }

    long long *counts = calloc(n_categories, sizeof(long long));
    if (!counts) return calloc(1,1);

    for (size_t i = 0; i < n_books; ++i) {
        const char *b = books[i];
        if (!b || b[0] == '\0') continue;
        char cat = b[0];
        /* find the number part: last space then atoi */
        const char *p = strrchr(b, ' ');
        if (!p) continue;
        long long qty = atoll(p + 1);
        for (size_t j = 0; j < n_categories; ++j) {
            if (categories[j] && categories[j][0] == cat) {
                counts[j] += qty;
            }
        }
    }

    /* compute required length */
    int total_len = 0;
    for (size_t j = 0; j < n_categories; ++j) {
        char letter = categories[j] ? categories[j][0] : '?';
        /* snprintf with NULL to get length needed */
        int l = snprintf(NULL, 0, "(%c : %lld)", letter, counts[j]);
        if (l < 0) l = 0;
        total_len += l;
    }
    if (n_categories > 1) total_len += 3 * (n_categories - 1); /* separators " - " */
    total_len += 1; /* null terminator */

    char *res = malloc((size_t)total_len);
    if (!res) {
        free(counts);
        return calloc(1,1);
    }

    char *ptr = res;
    int written = 0;
    for (size_t j = 0; j < n_categories; ++j) {
        char letter = categories[j] ? categories[j][0] : '?';
        written = sprintf(ptr, "(%c : %lld)", letter, counts[j]);
        if (written < 0) written = 0;
        ptr += written;
        if (j + 1 < n_categories) {
            memcpy(ptr, " - ", 3);
            ptr += 3;
        }
    }
    *ptr = '\0';

    free(counts);
    return res;
}

int main()
{
    char *books[] = { "ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60" };
    char *categories[] = { "A", "B", "C", "D" };

    char *result = stockSummary((const char *const *)books, 5, (const char *const *)categories, 4);

    if (result) {
        printf("%s\n", result);
        free(result);
    }
    return 0;
}
