// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

class Solution {
    public void generateCombination(List<List<Integer>> ans, List<Integer> ds, int[] candidates, int target, int n, int ind) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (ind >= n) {
            return;
        }
        if (candidates[ind] <= target) {
            ds.add(candidates[ind]);
            generateCombination(ans, ds, candidates, target - candidates[ind], n, ind);
            ds.remove(ds.size() - 1); 
        }
        generateCombination(ans, ds, candidates, target, n, ind + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombination(ans, new ArrayList<>(), candidates, target, candidates.length, 0);
        return ans;
    }
}
