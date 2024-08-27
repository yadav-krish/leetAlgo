// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.
// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
 
import java.util.*;

class Solution {
    class Pair {
        char ch;
        int count;

        // Constructor to initialize Pair
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair2.count, pair1.count));

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Create Pair objects and add them to the priority queue
        for (char key : map.keySet()) {
            Pair p = new Pair(key, map.get(key));
            pq.add(p);
        }

        // Build the result string
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = 0; i < pair.count; i++) {
                ans.append(pair.ch);
            }
        }

        return ans.toString();
    }
}
