// This is similar to problem "Binary Subarrays with sum" where odd number and even number is denoted by 1 and 0 respectively requiring some number of 1's in the array
// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.

// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
// Example 2:

// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There are no odd numbers in the array.
// Example 3:

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16
 

class Solution {
    public int nice(int[] nums, int k) {
        if (k < 0)
            return 0;
        int l = 0, r = 0, sum = 0, cnt = 0;
        while (r < nums.length) {
            sum += nums[r] % 2;
            while (l <= r && sum > k) {
                sum -= nums[l] % 2;
                l++;
            }
            cnt += r - l + 1;
            r++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return nice(nums, k) - nice(nums, k - 1);
    }
}
