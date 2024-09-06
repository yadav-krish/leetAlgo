// Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

// Example 1:

// Input:
// n = 6
// 1<->1<->1<->2<->3<->4
// Output:
// 1<->2<->3<->4
// Explanation:
// Only the first occurance of node with value 1 is 
// retained, rest nodes with value = 1 are deleted.
// Example 2:

// Input:
// n = 7
// 1<->2<->2<->3<->3<->4<->4
// Output:
// 1<->2<->3<->4
// Explanation:
// Only the first occurance of nodes with values 2,3 and 4 are 
// retained, rest repeating nodes are deleted.

class Solution{
    Node removeDuplicates(Node head){
        if(head==null)
        return null;
     Node last=head;
     Node curr=head.next;
        while(curr!=null)
        {
            if(curr.data==last.data)
            {
           curr=curr.next;
            }
           else 
           {
             last.next=curr;
             curr.prev=last;
             last=curr;
             curr=curr.next;
           }
        }
        last.next=null;
        return head;
    }
}
