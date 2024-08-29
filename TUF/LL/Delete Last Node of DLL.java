public class Solution
{
    public static Node deleteLastNode(Node head) {
        if(head.next==null)
        return null;
        Node curr=head;
        while(curr!=null)
        {
            if(curr.next.next==null)
            {
                curr.next=null;
                return head;
            }
            curr=curr.next;
        }
        return head;
    }
}
