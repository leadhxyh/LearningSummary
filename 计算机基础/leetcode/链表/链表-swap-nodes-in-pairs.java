/*
 *	Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given1->2->3->4, you should return the list as2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode newHead = null;
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode newCur = null;
            if (cur.next != null) {
                newCur = cur.next.next;
                
                if (newHead == null) {
                    newHead = cur.next;
                    newHead.next = cur;
                    last = cur;
                } else {
                    last.next = cur.next;
                    cur.next.next = cur;
                    last = cur;
                }
                
            } else {
                newCur = null;
                last.next = cur;
                last = last.next;
            }
            
            cur = newCur;
            if (cur == null)
                last.next = null;
        }
        return newHead;
    }
}
