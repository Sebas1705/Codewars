#include <stdio.h>
#include <inttypes.h>

uint32_t ips_between (const char *start, const char *end)
{
    uint32_t s1, s2, s3, s4;
    uint32_t e1, e2, e3, e4;

    sscanf(start, "%" SCNu32 ".%" SCNu32 ".%" SCNu32 ".%" SCNu32, &s1, &s2, &s3, &s4);
    sscanf(end, "%" SCNu32 ".%" SCNu32 ".%" SCNu32 ".%" SCNu32, &e1, &e2, &e3, &e4);

    uint32_t start_ip = (s1 << 24) | (s2 << 16) | (s3 << 8) | s4;
    uint32_t end_ip = (e1 << 24) | (e2 << 16) | (e3 << 8) | e4;

    return end_ip - start_ip;
}

int main()
{
    const char *start_ip = "20.0.0.10";
    const char *end_ip = "20.0.1.0";
    uint32_t result = ips_between(start_ip, end_ip);
    printf("Number of IPs between %s and %s: %" PRIu32 "\n", start_ip, end_ip, result);
    return 0;
}
