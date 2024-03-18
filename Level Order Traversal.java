// Given a root of a binary tree with n nodes, find its level order traversal.
// Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:

Input:
    1
  /   \ 
 3     2
Output:
1 3 2

Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:
10 20 30 40 60

class Solution
{
    //Function to return the level order traversal of a tree.
    
     static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        ArrayList<Integer> a=new ArrayList<>();
        Queue<Node> s = new LinkedList<>();
        s.add(root);
        while(!s.isEmpty())
        {
            Node t=s.peek();
            if(t.left!=null)
            {
                s.add(t.left);
            }
            if(t.right!=null)
            {
                s.add(t.right);
            }
            a.add(t.data);
            s.remove();
        }
        return a;
    }
}



  
