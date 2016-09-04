/*
 *	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null) 
            return l1;
        
        ListNode head = null;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode cur = null;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                if (head == null) {
                    head = t1;
                    cur = head;
                } else {
                    cur.next = t1;
                    cur = t1;
                }
                t1 = t1.next;
            } else {
                if (head == null) {
                    head = t2;
                    cur = head;
                } else {
                    cur.next = t2;
                    cur = t2;
                }
                t2 = t2.next;
            }
        }
        
        if (t1 != null)
            cur.next = t1;
        if (t2 != null)
            cur.next = t2;
        
        return head;
    }
}
