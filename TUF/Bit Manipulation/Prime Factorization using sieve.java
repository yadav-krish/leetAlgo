// You are given a positive number N. Using the concept of Sieve, compute its prime factorisation.

// Example:
// Input: 
// N = 12246
// Output: 
// 2 3 13 157
// Explanation: 
// 2*3*13*157 = 12246 = N.

class Solution {
    // You must implement this function
    static void sieve() {
    }

    static List<Integer> findPrimeFactors(int n) {
        List<Integer>ans=new ArrayList<>();
        int[]primes=new int[n+1];
        for(int i=2;i<=n;i++)
        primes[i]=1;
        for(int i=2;i*i<=n;i++)
        {
            if(primes[i]==1)
            {
                for(int j=i*i;j<=n;j+=i)
                primes[j]=0;
            }
        }
        if(primes[n]==1)
        {
            ans.add(n);
            return ans;
        }
        int product=1;
        for(int i=n-1;i>=2;i--)
        {
            if(primes[i]==1&&(n%(product*i)==0))
            {
                ans.add(i);
                product*=i;
                i++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

// Method 2
 static List<Integer> findPrimeFactors(int N) {
        // code here
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i<=Math.sqrt(N); i++) {
            if (N % i == 0){
                while(N % i == 0){
                    list.add(i);
                    N/=i;
                }
            }
        }
        if (N != 0 && N != 1)
        list.add(N);
        
        return list;
        
    }
}
