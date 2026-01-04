#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

bool is_valid_ip(const char *addr)
{
    if (!addr)
        return false;

    int parts = 0;
    const char *p = addr;

    while (*p) {
        if (parts == 4)
            return false; /* too many parts */

        /* disallow any whitespace anywhere */
        if (isspace((unsigned char)*p))
            return false;

        /* each part must start with a digit */
        if (!isdigit((unsigned char)*p))
            return false;

        /* detect leading zeros: a multi-digit number must not start with '0' */
        const char *start = p;
        int val = 0;
        int len = 0;

        if (*p == '0') {
            /* single zero is allowed, but not multiple digits starting with 0 */
            if (isdigit((unsigned char)*(p + 1)))
                return false;
            val = 0; p++; len = 1;
        } else {
            while (isdigit((unsigned char)*p)) {
                val = val * 10 + (*p - '0');
                if (val > 255)
                    return false;
                p++; len++;
            }
            if (len == 0)
                return false;
        }

        /* after the number must be a dot or end of string */
        if (*p == '.') {
            p++; parts++;
            if (*p == '\0') /* trailing dot -> invalid */
                return false;
            continue;
        } else if (*p == '\0') {
            parts++;
            break;
        } else {
            return false;
        }
    }

    return parts == 4;
}


int main()
{
    const char *test_ip = "192.0168.1.1";
    if (is_valid_ip(test_ip)) {
        printf("%s is a valid IP address.\n", test_ip);
    } else {
        printf("%s is not a valid IP address.\n", test_ip);
    }
    return 0;
}
