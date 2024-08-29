// Given an array of integer arr. Your task is to construct the linked list from arr & return the head of the linked list.

// Examples:

// Input: arr = [1, 2, 3, 4, 5]
// Output: LinkedList: 1->2->3->4->5

// Input: arr = [2, 4, 6, 7, 5, 1, 0]
// Output: LinkedList: 2->4->6->7->5->1->0

class Solution {
    static Node constructLL(int arr[]) {
        Node head=new Node(arr[0]);
        Node prev=head;
        for(int i=1;i<arr.length;i++)
        {
            Node n=new Node(arr[i]);
            prev.next=n;
            prev=n;
        }
        return head;
    }
}
