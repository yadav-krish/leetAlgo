// Given a number N. Find its unique prime factors in increasing order.
// Example 1:
// Input: N = 100
// Output: 2 5
// Explanation: 2 and 5 are the unique prime
// factors of 100.

// Example 2:
// Input: N = 35
// Output: 5 7
// Explanation: 5 and 7 are the unique prime
// factors of 35.
 

class Solution
{
    public int[] helper(int n)
    {
        int[]prime=new int[n+1];
        for(int i=2;i<=n;i++)
        {
            prime[i]=1;
        }
        for(int i=2;i*i<=n;i++)
        {
            if(prime[i]==1)
            {
                for(int j=i*i;j<=n;j+=i)
                prime[j]=0;
            }
        }
        return prime;
    }
    public int[] AllPrimeFactors(int n)
    {
        List<Integer>li=new ArrayList<>();
       int[]prime=helper(n);
       for(int i=2;i<=n;i++)
       {
           if(prime[i]==1&&(n%i==0))
           li.add(i);
       }
       int[]ans=new int[li.size()];
       for(int i=0;i<li.size();i++)
       {
           ans[i]=li.get(i);
       }
       return ans;
    }
}
