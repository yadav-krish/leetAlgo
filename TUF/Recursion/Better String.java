// Given a pair of strings of equal lengths, Geek wants to find the better string. The better string is the string having more number of distinct subsequences.
// If both the strings have equal count of distinct subsequence then return str1.

// Example 1:

// Input:
// str1 = "gfg", str2 = "ggg"
// Output: "gfg"
// Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct subsequences. 
// Example 2:

// Input: str1 = "a", str2 = "b"
// Output: "a"
// Explanation: Both the strings have only 1 distinct subsequence. 


class Solution {
    public static void findTotalSubsequences(HashSet<String>hash,StringBuilder s,String str,int ind,int n)
    {
        if(ind==n)
        {
            if(!hash.contains(s.toString()))
            hash.add(s.toString());
            return;
        }
        s.append(str.charAt(ind));
        findTotalSubsequences(hash,s,str,ind+1,n);
        s.deleteCharAt(s.length()-1);
        findTotalSubsequences(hash,s,str,ind+1,n);
    }
    public static String betterString(String str1, String str2) {
        HashSet<String>s1=new HashSet<>();
        HashSet<String>s2=new HashSet<>();
        findTotalSubsequences(s1,new StringBuilder(),str1,0,str1.length());
        findTotalSubsequences(s2,new StringBuilder(),str2,0,str2.length());
        if(s1.size()>=s2.size())
        return str1;
        else
        return str2;
    }
}
// Approach 2
class Solution {
    
    // Function to count distinct subsequences using dynamic programming
    public static int countDistinctSubsequences(String str) {
        int n = str.length();
        int[] dp = new int[n + 1]; // dp[i] stores the number of distinct subsequences up to index i
        dp[0] = 1; // Base case: empty string has 1 subsequence (the empty subsequence)

        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            char currentChar = str.charAt(i - 1);
            dp[i] = dp[i - 1] * 2; // Double the subsequences by including/excluding current character
            
            if (lastOccurrence.containsKey(currentChar)) {
                // Subtract the number of subsequences before the last occurrence of currentChar
                int lastIndex = lastOccurrence.get(currentChar);
                dp[i] -= dp[lastIndex - 1];
            }
            
            // Update the last occurrence of the current character
            lastOccurrence.put(currentChar, i);
        }
        
        return dp[n] - 1; // Subtract the empty subsequence
    }
    
    public static String betterString(String str1, String str2) {
        // Count distinct subsequences for both strings
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);
        
        // Return the string
          // Return the string with more distinct subsequences or str1 if they are equal
        if (count1 >= count2) {
            return str1;
        } else {
            return str2;
        }
    }
}
