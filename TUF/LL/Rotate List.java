// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
  
// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 
// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
            return head;
        
        // Step 1: Calculate the length of the list
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }
        
        // Step 2: Connect the tail to the head to form a circular list
        curr.next = head;

        // Step 3: Find the new tail: (n - k % n - 1)th node and new head: (n - k % n)th node
        k = k % n;
        int stepsToNewHead = n - k;

        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Break the circular list
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
