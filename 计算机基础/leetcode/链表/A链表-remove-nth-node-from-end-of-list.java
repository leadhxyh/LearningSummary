/*
 *	Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

/*
 * 注意要删除的元素是首元素的情况
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode pre = head;
        //前进n+1步
        int i = 0;
        for (i = 0; i <= n && pre != null; i++) {
            pre = pre.next;
        }
        //要删除的元素是第一个元素
        if (i != n + 1)
            return head.next;
        
        ListNode toBeDelete = head;
        while (pre != null) {
            pre = pre.next;
            toBeDelete = toBeDelete.next;
        }
        toBeDelete.next = toBeDelete.next.next;
        return head;
    }
}
