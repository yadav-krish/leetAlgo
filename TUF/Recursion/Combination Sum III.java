// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

class Solution {
    public void findCombinations(List<List<Integer>> ans, List<Integer> ds, int sum, int cnt, int k, int n, int start) {
        if (cnt == k && sum == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (cnt < k && sum < n) {
            for (int i = start; i <= 9; i++) {
                ds.add(i);
                findCombinations(ans, ds, sum + i, cnt + 1, k, n, i + 1);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(ans, new ArrayList<>(), 0, 0, k, n, 1);
        return ans;
    }
}
