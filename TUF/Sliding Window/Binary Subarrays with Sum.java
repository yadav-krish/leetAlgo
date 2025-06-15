// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

// A subarray is a contiguous part of the array.

// Example 1:

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// Example 2:

// Input: nums = [0,0,0,0,0], goal = 0
// Output: 15
 

class Solution {
    public int total_subarray(int[]nums,int goal)
    {
        if(goal<0)
        return 0;
        int l=0,r=0,sum=0,cnt=0;
        while(r<nums.length)
        {
            sum=sum+nums[r];
            while(l<=r&&sum>goal) // here <= is very important to work on single elements like nums={1}, goal=0
            {
                sum-=nums[l];
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return total_subarray(nums,goal)-total_subarray(nums,goal-1);
    }
}
