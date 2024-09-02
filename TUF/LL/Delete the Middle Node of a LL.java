class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
        return null;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.next==slow)
                curr.next=curr.next.next;
                curr=curr.next;
        }
        return head;
    }
}
