// Given a stack, the task is to sort it such that the top of the stack has the greatest element.

// Example 1:

// Input:
// Stack: 3 2 1
// Output: 3 2 1
// Example 2:

// Input:
// Stack: 11 2 32 3 41
// Output: 41 32 11 3 2

class GfG {
    public void insertInOrder(Stack<Integer>stack,int element)
    {
        if(stack.isEmpty()||stack.peek()<element)
        stack.push(element);
        else
        {
            int top=stack.pop();
            insertInOrder(stack,element);
            stack.push(top);
        }
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty())
        return s;
       int top=s.pop();
       sort(s);
       insertInOrder(s,top);
       return s;
    }
}
