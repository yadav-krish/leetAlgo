// Given a doubly linked list. Your task is to reverse the doubly linked list and return its head.

// Examples:

// Input: LinkedList: 3 <-> 4 <-> 5
// Output: 5 <-> 4 <-> 3

// class DLLNode {
//     int data;
//     DLLNode next;
//     DLLNode prev;

//     DLLNode(int val) {
//         data = val;
//         next = null;
//         prev = null;
//     }
// }

class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        DLLNode newHead=null;
        DLLNode curr=head;
        while(curr!=null){
            DLLNode temp=curr;
            if(curr.next==null)
            newHead=curr;
            curr=curr.next;
            DLLNode t=temp.next;
            temp.next=temp.prev;
            temp.prev=t;
        }
        return newHead;
    }
}
