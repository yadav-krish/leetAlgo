//There is a song concert going to happen in the city. The price of each ticket is equal to the number obtained after reversing the bits of a given 32 bits unsigned integer ‘n’.

#include<cmath>
long reverseBits(long n) {
long ans=0;
for(int i=31;i>=0;i--)
{
    if(pow(2,i)<=n)
    {
        ans=ans+pow(2,31-i);
        n-=pow(2,i);
    }
    if(n==0)
    break;
}
return ans;
}
// It's TC and SC will be O(1)
