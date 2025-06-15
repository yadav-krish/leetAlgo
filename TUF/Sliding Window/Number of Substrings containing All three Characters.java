// Approach - Modified Brute Force
class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int[] hash = new int[3];
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);
                hash[ch - 97] = 1;
                if (hash[0] + hash[1] + hash[2] == 3) {
                    cnt += len - j;
                    break;
                }
            }
        }
        return cnt;
    } 
}
// Approach 2 - considering each character as being the last character of the substrings, taking out last minimum index out of three characters
class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash={-1,-1,-1}; // do not write , cnt=0 because then cnt will be expected to be an integer array
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            hash[ch-'a']=i;
            cnt=cnt+(1+Math.min(hash[0],Math.min(hash[1],hash[2]))); // Maths function takes only two arguments that is why applied twice here
        }
        return cnt;
    }
}
