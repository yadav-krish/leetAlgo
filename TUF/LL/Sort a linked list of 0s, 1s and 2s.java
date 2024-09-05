// Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and 2s.

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        Node curr=head;
        while(curr!=null)
        {
            pq.add(curr.data);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null)
        {
            curr.data=pq.poll();
            curr=curr.next;
        }
        return head;
    }
}
