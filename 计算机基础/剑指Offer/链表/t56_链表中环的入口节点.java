/**
 *	һ�������а����������ҳ�������Ļ�����ڽ�㡣
 */

/**
 * �������룺1.�޻� 2.��������Ϊһ����
 */

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) 
            return null;
        if (pHead.next == pHead)
            return pHead;
        //Ѱ�һ��е�һ���ڵ�
        ListNode node = nodeInLoop(pHead);
        if (node == null)
            return null;
     
        //���㻷��Ԫ�ظ���
        ListNode node1 = node.next;
        int count = 1;
        while (node1 != node) {
            count++;
            node1 = node1.next;
        }
        //Ѱ�����
        ListNode ahead = pHead;
        ListNode behind = pHead;
  		for (int i = 0; i < count; i++) {
            ahead = ahead.next;
        }
       	while (ahead != behind) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return ahead;
        
        
    }
    //ͨ��һ��һ������ָ��Ѱ�һ��е�һ���ڵ㣬�޻�ʱ����null
    public ListNode nodeInLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        slow = slow.next;
        fast = fast.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow) 
            return fast;
        else 
            return null;
        
    }
}
