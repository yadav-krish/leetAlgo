// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
// A valid window can have more than 2 different characters.

class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0, start = 0, maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if ((i - start + 1) - maxFreq > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
}
