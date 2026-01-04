#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isValidWalk(const char *walk) 
{
    if (strlen(walk) != 10)
        return false;
    
    int x = 0, y = 0;
    for(int i = 0; i < 10; i++)
    {
        switch(walk[i])
        {
            case 'n':
                y++;
                break;
            case 's':
                y--;
                break;
            case 'e':
                x++;
                break;
            case 'w':
                x--;
                break;
            default:
                return false;
        }
    }

    return x == 0 && y == 0;
}

int main()
{
    const char *walk = "nsnsnsnsns";
    if(isValidWalk(walk))
        printf("Valid walk\n");
    else
        printf("Invalid walk\n");
    return 0;
}
