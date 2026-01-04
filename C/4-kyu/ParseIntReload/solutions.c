#include <stdio.h>
#include <string.h>
#include <stdlib.h>
static const char* unitsDict[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
static const char* teensDict[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
static const char* tensDict[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

static void process_token(const char *t, long *current, long *result) {
    if (t == NULL || t[0] == '\0') return;
    if (strcmp(t, "and") == 0) return;

    int i;
    for (i = 0; i < 10; ++i) {
        if (strcmp(t, unitsDict[i]) == 0) {
            *current += i;
            return;
        }
    }
    for (i = 0; i < 10; ++i) {
        if (strcmp(t, teensDict[i]) == 0) {
            *current += 10 + i;
            return;
        }
    }
    for (i = 2; i < 10; ++i) {
        if (strcmp(t, tensDict[i]) == 0) {
            *current += i * 10;
            return;
        }
    }
    if (strcmp(t, "hundred") == 0) {
        if (*current == 0) *current = 1;
        *current *= 100;
        return;
    }
    if (strcmp(t, "thousand") == 0) {
        if (*current == 0) *current = 1;
        *current *= 1000;
        *result += *current;
        *current = 0;
        return;
    }
    if (strcmp(t, "million") == 0) {
        if (*current == 0) *current = 1;
        *current *= 1000000;
        *result += *current;
        *current = 0;
        return;
    }
}

long parse_int (const char* number) 
{
    long result = 0;
    long current = 0;

    const char *p = number;
    char token[32];
    int ti = 0;

    while (*p) {
        if (*p == ' ' || *p == '-') {
            if (ti > 0) {
                token[ti] = '\0';
                process_token(token, &current, &result);
                ti = 0;
            }
            ++p;
            continue;
        }
        if (ti < (int)sizeof(token) - 1) {
            token[ti++] = *p;
        }
        ++p;
    }
    if (ti > 0) {
        token[ti] = '\0';
        process_token(token, &current, &result);
    }

    result += current;
    return result;
}

int main()
{
    printf("%ld\n", parse_int("seven hundred eighty-three thousand nine hundred and nineteen")); // 783919  
    return 0;
}
