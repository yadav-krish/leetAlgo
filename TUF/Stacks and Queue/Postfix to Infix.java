// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its infix form.

// Example:

// Input:
// ab*c+ 
// Output: 
// ((a*b)+c)
// Explanation: 
// The above output is its valid infix form.
class Solution {
    static String postToInfix(String exp) {
       Stack<String>stack=new Stack<>();
       for(int i=0;i<exp.length();i++)
       {
           char ch=exp.charAt(i);
           if(Character.isLetter(ch))
           stack.push(String.valueOf(ch));
           else
           {
               String top1=stack.pop();
               String top2=stack.pop();
               String temp="("+top2+String.valueOf(ch)+top1+")";
               stack.push(temp);
           }
       }
       return stack.peek();
    }
}
