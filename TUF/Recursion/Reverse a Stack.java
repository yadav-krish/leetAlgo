// You are given a stack St. You have to reverse the stack using recursion.

class Solution
{ 
    static void insertAtBottom(Stack<Integer>stack,int element)
    {
        if(stack.isEmpty())
        stack.push(element);
        else
        {
            int top=stack.pop();
            insertAtBottom(stack,element);
            stack.push(top);
        }
    }
    static void reverse(Stack<Integer> stack)
    {
        if(!stack.isEmpty())
        {
            int top=stack.pop();
            reverse(stack);
            insertAtBottom(stack,top);
        }
    }
}
