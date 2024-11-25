// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr.
// Note: It is guaranteed that the output fits in a 32-bit integer.
  
// Examples
// Input: arr[] = [-2, 6, -3, -10, 0, 2]
// Output: 180
// Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
// Input: arr[] = [-1, -3, -10, 0, 60]
// Output: 60
// Explanation: The subarray with maximum product is {60}.

// Kadane's Algorithm
class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n=arr.length;
        int ans=Integer.MIN_VALUE;
       int pre=1,post=1;
       for(int i=0;i<arr.length;i++)
       {
           if(pre==0)
           pre=1;
           if(post==0)
           post=1;
           pre*=arr[i];
           post*=arr[n-i-1];
           ans=Math.max(ans,Math.max(pre,post));
       }
      return ans; 
    }
}
