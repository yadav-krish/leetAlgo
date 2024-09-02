// Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head,slow=head;
        for(int i=0;i<n;i++)
        fast=fast.next;
        if(fast==null)
        return head.next;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
