// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode>hash=new HashSet<>();
        ListNode curr=head;
        while(curr!=null)
        {
            if(hash.contains(curr.next))
            return curr.next;
            hash.add(curr);
            curr=curr.next;
        }
        return null;
    }
}

// Approach 2: Tortoise and Hare Algorithm

public class Solution {
    public ListNode detectCycle(ListNode head) {
            boolean isCycle=false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
            {
                isCycle=true;
                break;
            }
        }
        if(isCycle==false)
        return null;

        slow=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
