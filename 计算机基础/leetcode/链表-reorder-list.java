/*
 *	Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */

/*
 *	思路：将后半部分链表翻转，加入到前半部分链表中
 */

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //计算链表长度
        int len = 0;
        ListNode tem = head;
        while (tem != null) {
            len++;
            tem = tem.next;
        }
        ListNode mid = head;
        int steps = (len + 1) / 2 - 1;
        for (int i = 0; i < steps; i++) {
            mid = mid.next;
        }
        ListNode t = mid;
        mid = mid.next;
        //将前半部分最后一个节点指向空
        t.next = null;
        
		//翻转后半部分链表
        mid = reverseList(mid);
        
        //将后半部分加入前半部分
        ListNode before = head;
        while (mid != null) {
            ListNode next = mid.next;
            
            mid.next = before.next;
            before.next = mid;
            
            before = before.next.next;
            mid = next;
        }
    }
    
    //翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode next = head;
        ListNode nextTmp;

        while (next != null) {
            nextTmp = next.next;
            next.next = cur;
            cur = next;
            next = nextTmp;
        }

        head = cur;
        return head;
    }
}
