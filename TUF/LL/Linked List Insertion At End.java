// Given the head of a Singly Linked List and a value x, insert that value x at the end of the LinkedList and return the modified Linked List.

// Examples :

// Input: LinkedList: 1->2->3->4->5 , x = 6
// Output: 1->2->3->4->5->6

class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        if(head==null)
        return new Node(x);
        Node n=new Node(x);
        Node curr=head;
        while(curr!=null)
        {
            if(curr.next==null)
            {
                curr.next=n;
                break;
            }
            curr=curr.next;
        }
        return head;
    }
}
