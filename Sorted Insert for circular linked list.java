// Given a sorted circular linked list of length n, the task is to insert a new node in this circular list so that it remains a sorted circular linked list.

// Example 1:

// Input:
// n = 3
// LinkedList = 1->2->4
// (the first and last node is connected, i.e. 4 --> 1)
// data = 2
// Output: 
// 1 2 2 4
// Explanation:
// We can add 2 after the second node.

// Example 2:

// Input:
// n = 4
// LinkedList = 1->4->7->9
// (the first and last node is connected, i.e. 9 --> 1)
// data = 5
// Output: 
// 1 4 5 7 9
// Explanation:
// We can add 5 after the second node.

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node curr = head;
        Node newNode = new Node(data);

        // when linked list is empty or new node is smaller than the head
        if (curr == null || curr.data >= data) {
            if (curr == null) {
                newNode.next = newNode;
                return newNode;
            } else {
                // Insert at the beginning
                newNode.next = curr;
                while (curr.next != head) {
                    curr = curr.next;
                }
                curr.next = newNode;
                return newNode;
            }
        } else {
            // Insert in the middle or at the end
            while (curr.next != head && curr.next.data < data) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            return head;
        }
    }
}
