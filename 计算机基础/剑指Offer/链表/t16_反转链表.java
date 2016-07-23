/**
 * ����һ��������ת�����������������Ԫ�ء�
 */

/**
 * ˼·��ʹ������ָ��last,head,next���ֱ�ָ��ǰ�ڵ�ǰһ���ڵ㣬��ǰ�ڵ㣬��ǰ�ڵ���һ���ڵ㡣��ʼʱ��lastָ��null��ʱ�临�Ӷȣ�O(n)
 * ����ֵ���ԣ�1��headΪ�� 2��ֻ��һ���ڵ�
 */


public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) 
            return null;

        ListNode last = null;
        ListNode next = null;
		while (head != null) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
            if (head == null) {
                return last;
            }
        }
        return null;
        
    }
}
