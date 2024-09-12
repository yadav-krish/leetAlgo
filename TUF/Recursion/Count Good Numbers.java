// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

class Solution {
    public long findPower(long base, long power, long mod )
    {
        if(power==0)
        return 1;
        if(power==1)
        return base;
        if(power%2==0)
        return (findPower((base*base)%mod,power/2,mod))%mod;
        else
        return (base*findPower(base,power-1,mod))%mod;
    }
    public int countGoodNumbers(long n) {
        long mod=1000000007;
        long evenPlaces=(n+1)/2;
        long oddPlaces=n/2;
        long odd=findPower(4,oddPlaces,mod);
        long even=findPower(5,evenPlaces,mod);
        return (int)((odd*even)%mod);
    }
}
