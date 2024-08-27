// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false

 // Approach 1
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Count frequency of characters in both strings
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }

        // Compare the frequency maps
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map1.getOrDefault(ch, 0).equals(map2.getOrDefault(ch, 0))) {
                return false;
            }
        }

        return true;
    }
}
// Approach 2

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
           map.put(ch1,map.getOrDefault(ch1,0)+1);
           map.put(ch2,map.getOrDefault(ch2,0)-1);
        }
        for(int val:map.values())
        {
            if(val!=0)
            return false;
        }
        return true;
    }
}
SC - O(26)
