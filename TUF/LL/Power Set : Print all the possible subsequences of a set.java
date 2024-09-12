// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public void generateSubsets(List<List<Integer>>ans,List<Integer>ds,int[]nums,int ind)
    {
       if(ind==nums.length)
       {
        ans.add(new ArrayList<>(ds));
        return;
       } 
       ds.add(nums[ind]);
       generateSubsets(ans,ds,nums,ind+1);
       ds.removeLast();
       generateSubsets(ans,ds,nums,ind+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        generateSubsets(ans,new ArrayList<>(),nums,0);
        return ans;
    }
}
