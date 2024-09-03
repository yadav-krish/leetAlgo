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
