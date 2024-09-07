// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode finalLL = new ListNode(-1);  // Dummy node to start the reversed list
        ListNode ans = finalLL;  // Set 'ans' as the reference to the dummy node
        int cnt = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
            cnt++;

            // When we have 'k' nodes in the stack, pop them and reverse
            if (cnt == k) {
                while (!stack.isEmpty()) {
                    finalLL.next = stack.pop();
                    finalLL = finalLL.next;
                }
                cnt = 0;
            }
        }

        // For any remaining nodes that are fewer than 'k', append them as-is
        Stack<ListNode> remainder = new Stack<>();
        while (!stack.isEmpty()) {
            remainder.push(stack.pop());
        }

        // Append the remaining part (not reversed)
        while (!remainder.isEmpty()) {
            finalLL.next = remainder.pop();
            finalLL = finalLL.next;
        }

        finalLL.next = null;  // Ensure the last node points to null
        return ans.next;  // Return the new head (skipping the dummy node)
    }
}
