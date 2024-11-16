// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its prefix form.

// Example 1:

// Input: 
// ABC/-AK/L-*
// Output: 
// *-A/BC-/AKL
// Explanation: 
// The above output is its valid prefix form.

class Solution {
    static String postToPre(String post_exp) {
    Stack<String>stack=new Stack<>();
       for(int i=0;i<post_exp.length();i++)
       {
           char ch=post_exp.charAt(i);
           if(Character.isLetterOrDigit(ch))
           stack.push(String.valueOf(ch));
           else
           {
               String top1=stack.pop();
               String top2=stack.pop();
               String temp=String.valueOf(ch)+top2+top1;
               stack.push(temp);
           }
       }
       return stack.peek();
    }
}
