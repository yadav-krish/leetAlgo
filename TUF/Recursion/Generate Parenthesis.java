// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]

class Solution {
    public void findCombination(List<String> ans, String curr, int open, int close, int n) {
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }
        if (open < n)
            findCombination(ans, curr + "(", open + 1, close, n);
        if (close < n && open > close)
            findCombination(ans, curr + ")", open, close + 1, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        findCombination(ans, "", 0, 0, n);
        return ans;
    }
}
