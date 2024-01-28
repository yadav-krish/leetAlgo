//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

//Given a string s, return true if it is a palindrome, or false otherwise.

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!isAlphaNumeric(ch1)) { //its executed when it is false
                i++;
                continue;
            }
            if (!isAlphaNumeric(ch2)) {
                j--;
                continue;
            }
            if (ch1 >= 65 && ch1 <= 90)
                ch1 = (char) (ch1 + 32);
            if (ch2 >= 65 && ch2 <= 90)
                ch2 = (char) (ch2 + 32);
            if (ch1 == ch2) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }

    boolean isAlphaNumeric(char ch) {
        if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57))
            return true;
        else
            return false;
    }
}
