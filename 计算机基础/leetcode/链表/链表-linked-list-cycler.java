/*
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
 *	
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow)
            return true;
        else 
            return false;
    }
}
