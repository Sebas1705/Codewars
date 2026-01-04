#include <stdio.h>
#include <inttypes.h>

void uint32_to_ip (uint32_t number, char ipv4[sizeof "255.255.255.255"])
{
    snprintf(ipv4, sizeof "255.255.255.255", "%u.%u.%u.%u", (number >> 24) & 0xFF, (number >> 16) & 0xFF, (number >> 8) & 0xFF, number & 0xFF);
}

int main()
{
    char ipv4[sizeof "255.255.255.255"];
    uint32_to_ip(2149583361, ipv4);
    printf("%s\n", ipv4);  // Expected output: "128.32.10.1"
    return 0;
}
