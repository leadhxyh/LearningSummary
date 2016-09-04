/*
 *	Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given1->2->3->4->5->NULLand k =2,
return4->5->1->2->3->NULL.
 */

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return head;
        
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int offset = n % len;
        
        
        if (len == 1 || offset == 0)
            return head;
        
        int foward = len - offset;
        
        ListNode tail = head;
        for (int i = 0; i < foward - 1; i++) {
            tail = tail.next;
        }
        
        ListNode newHead = tail.next;
        tail.next = null;
        
        ListNode p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        
        return newHead;
    }
}
