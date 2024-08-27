// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int minlen = Integer.MAX_VALUE;
        for (String str : strs) {
            minlen = Math.min(minlen, str.length());
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < minlen; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return ans.toString();
                }
            }
            ans.append(ch);
        }
        
        return ans.toString();
    }
}
