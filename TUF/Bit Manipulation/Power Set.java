// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.
// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  
// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
 
// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<((1<<n));i++)
        {
          List<Integer>temp=new ArrayList<>();
          int ind=-1;
          while(++ind<n)
          {
            if((i&(1<<ind))!=0)
            temp.add(nums[ind]);
          }
          ans.add(temp);      
        }
        return ans;
    }
}
