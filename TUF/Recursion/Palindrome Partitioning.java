// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]

class Solution {
    public void partitionMaker(String s, List<String> temp, List<List<String>> ans, int ind) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                temp.add(s.substring(ind, i + 1));
                partitionMaker(s, temp, ans, ind + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionMaker(s, new ArrayList<>(), ans, 0);
        return ans;
    }
}
