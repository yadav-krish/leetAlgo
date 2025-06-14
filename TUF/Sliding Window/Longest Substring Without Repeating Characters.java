// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = -1, currlen = 0;
        int start = 0;
        int[] charArr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charArr[ch] == 0) {
                currlen++;
                charArr[ch]++;
                ans = Math.max(ans, currlen);
            } else {
                while (charArr[ch] != 0) {
                    char tempChar = s.charAt(start);
                    charArr[tempChar]--;
                    start++;
                    currlen--;
                }
                charArr[ch]++;
                currlen++;
            }
        }
        return ans == -1 ? 0 : ans;
    }
}
// Approach 2

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        Set<Character>hash=new HashSet<>();
        int l=0,r=0,ans=0;
        while(r<len)
            {
                char ch=s.charAt(r);
                while(hash.contains(ch)&&l<r)
                    {
                        hash.remove(s.charAt(l));
                        l++;
                    }
                hash.add(ch);
                ans=Math.max(ans,r-l+1);
                r++;
            }
        return ans;
    }
}
// Best Approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int len=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int l=0,r=0;
        while(r<len)
            {
                char ch=s.charAt(r);
                if(map.containsKey(ch))
                    l=Math.max(map.get(ch)+1,l);
                map.put(ch,r);
                ans=Math.max(ans,r-l+1);
                r++;
            }
        return ans;
    }
}
