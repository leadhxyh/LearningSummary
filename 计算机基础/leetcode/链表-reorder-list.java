/*
 *	Given a singly linked list L: L0��L1������Ln-1��Ln,
reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */

/*
 *	˼·������벿������ת�����뵽ǰ�벿��������
 */

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //����������
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
        //��ǰ�벿�����һ���ڵ�ָ���
        t.next = null;
        
		//��ת��벿������
        mid = reverseList(mid);
        
        //����벿�ּ���ǰ�벿��
        ListNode before = head;
        while (mid != null) {
            ListNode next = mid.next;
            
            mid.next = before.next;
            before.next = mid;
            
            before = before.next.next;
            mid = next;
        }
    }
    
    //��ת����
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
