// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

 

// Example 1:

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
// Example 2:

// Input: s = "aabcbaa"
// Output: 17

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                hash[ch - 'a']++;

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                
                // Calculate max and min frequencies in the current substring
                for (int k = 0; k < 26; k++) {
                    if (hash[k] > 0) {
                        maxi = Math.max(maxi, hash[k]);
                        mini = Math.min(mini, hash[k]);
                    }
                }

                sum += maxi - mini;
            }
        }
        return sum;
    }
}
