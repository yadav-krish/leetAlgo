// Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

// Note: Answer can be very large, so, output answer modulo 109+7.

// Examples:

// Input: 
// n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
// Output: 
// 3
// Explanation: 
// {5, 2, 3}, {2, 8}, {10} are possible subsets.
// Input: 
// n = 5, arr = [2, 5, 1, 4, 3], sum = 10
// Output: 
// 3
// Explanation: 
// {2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.

class Solution{
    public void findSubsets(int[]arr,int[]cnt,int ind,int n,int target)
    {
        if(ind==n)
        {
            if(target==0)
                cnt[0]++;
            return;
        }
        if(arr[ind]<=target)
        findSubsets(arr,cnt,ind+1,n,target-arr[ind]);
        findSubsets(arr,cnt,ind+1,n,target);
    }
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[]cnt=new int[1];
	    findSubsets(arr,cnt,0,arr.length,sum);
	    return cnt[0];
	} 
}
Approach 2: DP
  class Solution {
    public int perfectSum(int arr[], int n, int sum) {
        // Create a dp array to store results of subproblems
        int[][] dp = new int[n + 1][sum + 1];

        // Base case: There's one way to get sum 0 (using the empty set)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // Exclude the current element
                dp[i][j] = dp[i - 1][j];
                
                // Include the current element if it's not larger than the current sum j
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The answer is the number of subsets with sum equal to the target
        return dp[n][sum];
    }
}
Approach 3:
class Solution {
    static int MOD = 1000000007;

    public static int perfectSum(int[] arr, int n, int sum) {
        // Create a dp array to store the count of subsets with sum j
        int[] dp = new int[sum + 1];

        // Base case: There is 1 way to get sum 0 (by using the empty set)
        dp[0] = 1;

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            // Update dp array in reverse to avoid overwriting values
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % MOD;
            }
        }

        // Return the number of subsets that sum up to the target
        return dp[sum];
    }
}
