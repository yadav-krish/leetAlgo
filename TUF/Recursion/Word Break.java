// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
 
// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

// Brute Force O(n*(2^n))
class Solution {
    public boolean check(HashSet<String> hash, String s) {
        int n = s.length();
        if (s == "")
            return true;
        if (hash.contains(s))
            return true;
        for (int len = 1; len <= n; len++) {
            String temp = s.substring(0, len);
            if (hash.contains(temp) && check(hash, s.substring(len, n)))
                return true;
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hash = new HashSet<>();
        for (String word : wordDict) {
            hash.add(word);
        }
        return check(hash, s);
    }
}
// Memoization O(n^2)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>hash=new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]&&hash.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
