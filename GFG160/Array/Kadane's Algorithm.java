// Given an integer array arr[]. You need to find the maximum sum of a subarray.

// Examples:

// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11
// Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
// Input: arr[] = [-2, -4]
// Output: -2
// Explanation: The subarray {-2} has the largest sum -2.
// Input: arr[] = [5, 4, 1, 7, 8]
// Output: 25
// Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.
class Solution {
    int maxSubarraySum(int[] arr) {
    int ans=Integer.MIN_VALUE,temp=0;
    for(int i=0;i<arr.length;i++)
    {
        temp+=arr[i];
        ans=Math.max(temp,ans);
        if(temp<0)
        temp=0;
    }
    return ans;
    }
}
