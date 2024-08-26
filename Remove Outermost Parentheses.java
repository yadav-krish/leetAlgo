// Example 1:

// Input: s = "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
// Example 2:

// Input: s = "(()())(())(()(()))"
// Output: "()()()()(())"
// Explanation: 
// The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
// After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        StringBuilder ans=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
             if(cnt!=0)
             ans.append(ch);
             cnt++;
            }
            else
            {
                if(cnt>1)
                ans.append(ch);
                cnt--;
            }
        }
        return ans.toString();
    }
}
// Using Stack
class Solution {
    public String removeOuterParentheses(String s) {
     Stack<Character>stack=new Stack<>();
     StringBuilder ans=new StringBuilder();
     for(char ch:s.toCharArray())   
     {
        if(ch=='(')
        {
            if(stack.size()!=0)
            ans.append(ch);
            stack.push(ch);
        }
        else
        {
            if(stack.size()>1)
            ans.append(ch);
            stack.pop();
        }
     }
     return ans.toString();
    }
}
