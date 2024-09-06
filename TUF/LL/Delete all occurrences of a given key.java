// You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

// Example1:

// Input: 
// 2<->2<->10<->8<->4<->2<->5<->2
// 2
// Output: 
// 10<->8<->4<->5
// Explanation: 
// All Occurences of 2 have been deleted.

// Example2:

// Input: 
// 9<->1<->3<->4<->5<->1<->8<->4
// 9
// Output: 
// 1<->3<->4<->5<->1<->8<->4
// Explanation: 
// All Occurences of 9 have been deleted.
// Your Task:

// Complete the function void deleteAllOccurOfX(struct Node** head_ref, int key), which takes the reference of the head pointer and an integer value key. Delete all occurrences of the key from the given DLL.

// Expected Time Complexity: O(N).

// Expected Auxiliary Space: O(1).

// Constraints:

// 1<=Number of Nodes<=105

// 0<=Node Value <=109


class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // If the head node has value x, move the head to the next node
        while (head != null && head.data == x) {
            head = head.next;
        }

        // Initialize prev and curr pointers
        Node prev = null;
        Node curr = head;

        // Traverse the list
        while (curr != null) {
            if (curr.data == x) {
                // If current node needs to be deleted
                if (prev != null) {
                    // Unlink the current node from the list
                    prev.next = curr.next;
                }
                if (curr.next != null) {
                    curr.next.prev = prev;
                }
            } else {
                // Move the prev pointer only if we don't delete the current node
                prev = curr;
            }
            // Move to the next node
            curr = curr.next;
        }

        return head;
    }
}

// Some Modification
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // If the head node has value x, move the head to the next node
        while (head != null && head.data == x) {
            head = head.next;
        }

        // Initialize prev and curr pointers
        Node prev = null;
        Node curr = head;

        // Traverse the list
        while (curr != null) {
            if (curr.data == x) {
              while(curr!=null&&curr.data==x)
              curr=curr.next;
              prev.next=curr;
              if(curr!=null)
              curr.prev=prev;
              prev=curr;
            }
            else
            prev=curr;
            if(curr!=null)
            curr = curr.next;
        }

        return head;
    }
}

