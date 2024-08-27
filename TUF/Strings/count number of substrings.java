// Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

// Example 1:

// Input: S = "aba", K = 2
// Output:3
// Explanation:The substrings are: "ab", "ba" and "aba".
// Input: S = "abaaca", K = 1
// Output: 7
// Explanation: The substrings are: "a", "b", "a", "aa", "a", "c", "a". 

// Approach 1: Brute Force

class Solution
{
    long substrCount (String s, int k) {
        int n=s.length();
        long ans=0;
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            HashMap<Character,Integer>map=new HashMap<>();
            for(int j=i;j<n;j++)
            {
                char ch=s.charAt(j);
               if(map.getOrDefault(ch,0)==0) 
               {
               cnt++;
               map.put(ch,1);
               }
               if(cnt>k)
               break;
               else if(cnt==k)
               ans++;
            }
        }
        return ans;
    }
}
// Approach 2: Sliding Window
class Solution {
    private long atMostKDistinct(String s, int k) {
        int i = 0, j = 0;
        int n = s.length();
        int[] hash = new int[26];
        long ans = 0;
        int cnt = 0;

        while (j < n) {
            hash[s.charAt(j) - 'a']++;
            if (hash[s.charAt(j) - 'a'] == 1)
                cnt++;
            
            while (cnt > k) {
                hash[s.charAt(i) - 'a']--;
                if (hash[s.charAt(i) - 'a'] == 0) {
                    cnt--;
                }
                i++;
            }

            ans += j - i + 1;  // Count all valid substrings ending at `j`
            j++;
        }

        return ans;
    }
