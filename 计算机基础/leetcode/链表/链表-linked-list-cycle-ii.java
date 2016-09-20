/*
 *	Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
Follow up:
Can you solve it without using extra space?
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != slow)
            return null;
        
        int count = 1;
        ListNode tmp = fast.next;
        while (tmp != fast) {
            count++;
            tmp = tmp.next;
        }
        ListNode before = head;
        for (int i = 0; i < count; i++) {
            before = before.next;
        }
        
        ListNode last = head;
        while (before != last) {
            before = before.next;
            last = last.next;
        }
        return last;
            
    }
}
