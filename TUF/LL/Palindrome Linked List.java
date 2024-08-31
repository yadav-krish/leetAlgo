// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.

// Approach 1
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>stack=new Stack<>();
        ListNode curr=head;
        while(curr!=null)
        {
            stack.push(curr.val);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null)
        {
            if(curr.val!=stack.pop())
            return false;
            curr=curr.next;
        }
        return true;
    }
}
// Approach 2 : StringBuilder can also be used 
class Solution {
    public boolean isPalindrome(ListNode head) {
        String x="";
        ListNode curr=head;
        while(curr!=null)
        {
            x=x+(Integer.toString(curr.val));
            curr=curr.next;
        }
        int f=0,e=x.length()-1;
        while(f<=e)
        {
            if(x.charAt(f)!=x.charAt(e))
            return false;   
            f++;
            e--;
        }
        return true;
    }
// Approach 3
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int left = 0;
        int right = list.size()-1;
        while(left < right && list.get(left) == list.get(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}
