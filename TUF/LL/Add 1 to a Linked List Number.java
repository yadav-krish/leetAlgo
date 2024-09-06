// You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

// Note: The head represents the first element of the given array.


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        Node notNine=null;
        Node curr=head;
        while(curr!=null)
        {
            if(curr.data!=9)
            notNine=curr;
            curr=curr.next;
        }
        if(notNine==null)
        {
            Node newHead=new Node(1);
            newHead.next=head;
            curr=newHead.next;
            while(curr!=null)
            {
                curr.data=0;
                curr=curr.next;
            }
            return newHead;
        }
        else
        {
            int flag=0;
            curr=head;
            while(curr!=null)
            {
                if(curr==notNine)
                {
                    flag=1;
                    curr.data=curr.data+1;
                }
                else if(flag==1&&curr.data==9)
                curr.data=0;
                curr=curr.next;
            }
            return head;
        }
    }
}
