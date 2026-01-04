#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *rot13(const char *src)
{
    size_t n = strlen(src) + 1;
    char *dest = (char *)malloc(n * sizeof(char));
    for (size_t i = 0; i < n; i++)
    {
        if ((src[i] >= 'a' && src[i] <= 'm') || (src[i] >= 'A' && src[i] <= 'M'))
        {
            dest[i] = src[i] + 13;
        }
        else if ((src[i] >= 'n' && src[i] <= 'z') || (src[i] >= 'N' && src[i] <= 'Z'))
        {
            dest[i] = src[i] - 13;
        }
        else
        {
            dest[i] = src[i];
        }
    }
    return dest;
}

int main()
{
    const char *text = "Hello, World!";
    char *encoded = rot13(text);
    printf("Original: %s\n", text);
    printf("Encoded: %s\n", encoded);
    return 0;
}
