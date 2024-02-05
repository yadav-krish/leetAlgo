// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
  
// Example 1:
// Input: s = "leetcode"
// Output: 0

// Example 2:
// Input: s = "loveleetcode"
// Output: 2

// Example 3:
// Input: s = "aabb"
// Output: -1
  
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char,int>charMap;
        for(auto ch:s)
        {
            charMap[ch]++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(charMap[s[i]]==1)
            return i;
        }
        return -1;
    }
};
 
