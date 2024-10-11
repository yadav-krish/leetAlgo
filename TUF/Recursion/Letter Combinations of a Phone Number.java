// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

class Solution {
    public void findCombinations(List<String> ans, StringBuilder str, String digits, HashMap<Integer, String> map, int cnt, int n) {
        if (cnt == n) {
            ans.add(str.toString());
            return;
        }
        String keyVal = map.get(digits.charAt(cnt) - '0');
        for (int i = 0; i < keyVal.length(); i++) {
            str.append(keyVal.charAt(i));
            findCombinations(ans, str, digits, map, cnt + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        List<String> ans = new ArrayList<>();
        findCombinations(ans, new StringBuilder(), digits, map, 0, digits.length());
        return ans;
    }
}
