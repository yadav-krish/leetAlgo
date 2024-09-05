// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

// For example, the following two linked lists begin to intersect at node c1:

// The test cases are generated such that there are no cycles anywhere in the entire linked structure.

// Note that the linked lists must retain their original structure after the function returns.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       HashSet<ListNode>set=new HashSet<>();
       ListNode curr=headA;
      while(curr!=null)
      {
        set.add(curr);
        curr=curr.next;
      }
      curr=headB;
      while(curr!=null)
      {
        if(set.contains(curr))
        return curr;
        curr=curr.next;
      }
      return null;
    }
}

//Length Difference Solution
//Time Complexity : O(m + n)
//Space Complexity : O(1)


public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        int m = 0;
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        // Count the nodes in the first linked list
        while (ptr1 != null) {
            n++;
            ptr1 = ptr1.next;
        }

        // Count the nodes in the second linked list
        while (ptr2 != null) {
            m++;
            ptr2 = ptr2.next;
        }

        int t = Math.abs(n - m);

        // Move the pointer of the longer linked list to make their lengths equal
        if (n > m) {
            while (t > 0) {
                headA = headA.next;
                t--;
            }
        } else {
            while (t > 0) {
                headB = headB.next;
                t--;
            }
        }

        // Iterate through both linked lists until an intersection is found
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // Intersection found
            }
            headA = headA.next;
            headB = headB.next;
        }

        // No intersection found
        return null;
    }
}

//Two-Pointers Solution
//Time Complexity : O(m + n)
//Space Complexity : O(1)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null) return null;

    ListNode temp1 = headA;
    ListNode temp2 = headB;

    while (temp1 != temp2) {

        temp1 = temp1.next;
        temp2 = temp2.next;

        if (temp1 == temp2) return temp1;

        if (temp1 == null) temp1 = headB;
        if (temp2 == null) temp2 = headA;
    }

    return temp1;
        
 }
}
    }
}
