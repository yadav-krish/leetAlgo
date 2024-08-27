// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

class Solution {
    public String reverseWords(String s) {
        s.trim();
        s+=" ";
        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=' ')
            temp.append(ch);
            else if(temp.length()!=0){
                temp.append(" ");
                ans.insert(0,temp);
                temp.delete(0,temp.length());
            }
        }
        return ans.toString().trim();
    }
}

// Approach 2

class Solution {
    public String reverseWords(String s) {
        s+=" ";
        Stack<String>stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch!=' ')
            temp.append(ch);
            else if(temp.length()!=0)
            {
                stack.push(temp.toString());
                temp.delete(0,temp.length());
            }
        }
        while(!stack.isEmpty())
        {
            ans.append(stack.pop());
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}
