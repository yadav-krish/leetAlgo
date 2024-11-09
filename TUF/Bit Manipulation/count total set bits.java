// You are given a number n. Find the total count of set bits for all numbers from 1 to n (both inclusive).

// Examples :

// Input: n = 4
// Output: 5
// Explanation: For numbers from 1 to 4. For 1: 0 0 1 = 1 set bits For 2: 0 1 0 = 1 set bits For 3: 0 1 1 = 2 set bits For 4: 1 0 0 = 1 set bits Therefore, the total set bits is 5.
// Input: n = 17
// Output: 35
// Explanation: From numbers 1 to 17(both inclusive), the total number of set bits is 35.
// Expected Time Complexity: O(logn)
// Expected Auxiliary Space: O(1)

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int findHighestPow(int n)
    {
        int x=0;
        while((1<<x)<=n)
        {
            x++;
        }
        return x-1;
    }
    public static int countSetBits(int n){
        if(n<=0)
        return 0;
    int x=findHighestPow(n);
    int s1=x*(1<<x-1);
    int s2=n-(1<<x)+1;
    int rem=n-(1<<x);
    return s1+s2+countSetBits(rem);
    }
}
