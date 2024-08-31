// Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        // Step 1: Detect cycle in the linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        // Step 2: If no cycle, return 0
        if (!isCycle) {
            return 0;
        }

        // Step 3: Count the number of nodes in the loop
        int cnt = 1;
        slow = slow.next;
        while (slow != fast) {
            cnt++;
            slow = slow.next;
        }

        return cnt;
    }
}


