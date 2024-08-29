// Given a doubly-linked list, a position p, and an integer x. The task is to add a new node with value x at the position just after pth node in the doubly linked list.

// Example 1:

// Input:
// LinkedList: 2<->4<->5
// p = 2, x = 6 
// Output: 2 4 5 6
// Explanation: p = 2, and x = 6. So, 6 is
// inserted after p, i.e, at position 3
// (0-based indexing).
// Example 2:

// Input:
// LinkedList: 1<->2<->3<->4
// p = 0, x = 44
// Output: 1 44 2 3 4
// Explanation: p = 0, and x = 44 . So, 44
// is inserted after p, i.e, at position 1
// (0-based indexing).

// class Node
// {
// 	int data;
// 	Node next;
// 	Node prev;
// 	Node(int data)
// 	{
// 	    this.data = data;
// 	    next = prev = null;
// 	}
// }

class GfG
{
    // Function to insert a new node at the given position in a doubly linked list.
     void addNode(Node head_ref, int pos, int data)
    {
        int p = 0;
        Node temp = head_ref;
        while(p<pos){
            temp = temp.next;
            p++;
        }
        Node n = new Node(data);
        n.next = temp.next;
        n.prev = temp;
        temp.next = n;
    }
}
