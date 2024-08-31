// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode>hash=new HashSet<>();
        ListNode curr=head;
        while(curr!=null)
        {
            if(hash.contains(curr.next))
            return true;
            hash.add(curr);
            curr=curr.next;
        }
        return false;
    }
}
// Approach 2: O(1) Space Complexity Tortoise Hare Algorithm

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow= head;

        while(fast != null && fast.next != null){ 
            slow= slow.next;
            fast= fast.next.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
