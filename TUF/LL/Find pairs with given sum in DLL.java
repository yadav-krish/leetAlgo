// Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

// Example 1:

// Input:  
// 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
// target = 7
// Output: (1, 6), (2,5)
// Explanation: We can see that there are two pairs 
// (1, 6) and (2,5) with sum 7.
 
// Example 2:
// Input: 
// 1 <-> 5 <-> 6
// target = 6
// Output: (1,5)
// Explanation: We can see that there is one pairs  (1, 5) with sum 6.

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
     ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
     Node left=null,right=null;
     left=head;
     Node curr=head;
     while(curr!=null)
     {
         if(curr.next==null)
         right=curr;
         curr=curr.next;
     }
     while(left!=null&&right!=null&&left!=right&&left.prev!=right)
     {
        int sum=left.data+right.data;
        if(sum==target)
        {
        ans.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
        left=left.next;
        right=right.prev;
        }
        else if(sum>target)
        right=right.prev;
        else
        left=left.next;
     }
     return ans;
    }
}
        
