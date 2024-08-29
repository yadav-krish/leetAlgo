class Solution {
    Node constructDLL(int arr[]) {
       Node head=new Node(arr[0]);
       Node last=head;
       Node curr=head;
      for(int i=1;i<arr.length;i++)
       {
           Node n=new Node(arr[i]);
           last.next=n;
           n.prev=last;
           last=n;
       }
       return head;
    }
}
