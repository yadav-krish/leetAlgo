// You are given a string S of size N that represents the prefix form of a valid mathematical expression. The string S contains only lowercase and uppercase alphabets as operands and the operators are +, -, *, /, %, and ^.Convert it to its infix form.

// Example 1:

// Input: 
// *-A/BC-/AKL
// Output: 
// ((A-(B/C))*((A/K)-L))
// Explanation: 
// The above output is its valid infix form.

class Solution {
    static String preToInfix(String pre_exp) {
        int n=pre_exp.length();
        Stack<String>stack=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            stack.push(String.valueOf(ch));
            else
            {
                String top1=stack.pop();
                String top2=stack.pop();
                String temp="("+top1+String.valueOf(ch)+top2+")";
                stack.push(temp);
            }
        }
        return stack.peek();
    }
}
