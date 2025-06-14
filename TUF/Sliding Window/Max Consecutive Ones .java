// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroes=0,ans=0,s=0;
        for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==0)
                    zeroes++;
                if(zeroes>k)
                {
                    while(s<=i&&zeroes>k)
                        {
                            if(nums[s]==0)
                                zeroes--;
                            s++;
                        }
                }
                ans=Math.max(ans,i-s+1); 
            }
        return ans;
    }
}
// start and end both only move forward, never backward.
// Each element in the array is processed at most twice (once by end, once by start).
// Therefore, total operations = O(2n) = O(n)

// Approach 2
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroes = 0, ans = 0, ind = 0, start = 0;
        int[] zeroes_ind = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes_ind[ind++] = i;
                zeroes++;
            }
            if (zeroes > k)
            {
                zeroes--;
                start++;
            }
            int left;
            if(start==0)
                left=0;
            else
                left=zeroes_ind[start-1]+1;
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
