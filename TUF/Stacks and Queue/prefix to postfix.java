// You are given a string that represents the prefix form of a valid mathematical expression. Convert it to its postfix form.

// Example:

// Input: 
// *-A/BC-/AKL
// Output: 
// ABC/-AK/L-*
// Explanation: 
// The above output is its valid postfix form.

class Solution {
    static String preToPost(String pre_exp) {
       Stack<String>stack=new Stack<>();
       for(int i=pre_exp.length()-1;i>=0;i--)
       {
           char ch=pre_exp.charAt(i);
           if(Character.isLetterOrDigit(ch))
           stack.push(String.valueOf(ch));
           else
           {
               String top1=stack.pop();
               String top2=stack.pop();
               String temp=top1+top2+String.valueOf(ch);
               stack.push(temp);
           }
       }
       return stack.peek();
    }
}
