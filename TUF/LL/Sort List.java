// Given the head of a linked list, return the list after sorting it in ascending order.

class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer>li=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null)
        {
            li.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(li);
        curr=head;
        int cnt=0;
        while(curr!=null)
        {
            curr.val=li.get(cnt++);
            curr=curr.next;
        }
        return head;
    }
}
// Approach 2

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Function to merge two sorted linked lists
    public ListNode joinNodes(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode newNode = new ListNode(-1); // Dummy node
        ListNode temp = newNode;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        if (node1 != null) temp.next = node1;
        if (node2 != null) temp.next = node2;

        return newNode.next;
    }

    // Function to find the middle node of a linked list
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To split the list into two parts

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // Split the list into two halves
        }

        return slow;
    }

    // Function to sort the linked list using merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find the middle of the list
        ListNode middle = middleNode(head);
        ListNode left = head;
        ListNode right = middle;

        // Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge the two sorted halves
        return joinNodes(left, right);
    }
}

// Modification
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Function to merge two sorted linked lists
    public ListNode joinNodes(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode newNode = new ListNode(-1); // Dummy node
        ListNode temp = newNode;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                temp=node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                temp=node2;
                node2 = node2.next;
            }
        }

        if (node1 != null) temp.next = node1;
        if (node2 != null) temp.next = node2;

        return newNode.next;
    }

    // Function to find the middle node of a linked list
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to sort the linked list using merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find the middle of the list
        ListNode middle = middleNode(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next=null;

        // Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge the two sorted halves
        return joinNodes(left, right);
    }
}


