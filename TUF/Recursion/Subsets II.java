// Given an integer array nums that may contain duplicates, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]

class Solution {
    public void findSubsets(List<List<Integer>>ans,List<Integer>temp,int[]nums,int ind,int n)
    {
        if(ind==n)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        findSubsets(ans,temp,nums,ind+1,n);
        temp.remove(temp.size()-1);
        findSubsets(ans,temp,nums,ind+1,n);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        findSubsets(ans,new ArrayList<>(),nums,0,nums.length);
        Set<List<Integer>>set=new HashSet<>(ans);
        ans=new ArrayList<>(set);
        return ans;
    }
}
