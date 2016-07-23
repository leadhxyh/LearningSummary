/**
 *	���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */

/**
 *	ʱ�临�Ӷȣ�O(n)
 *	����ֵ���ԣ�1������Ϊ�� 2������һ��Ϊ��
 */

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode newHead = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (newHead == null) {
                    newHead = list1;
                }
                ListNode last = list1;
                list1 = list1.next;
                last.next = list2;
            } else {
                if (newHead == null) {
                    newHead = list2;
                }
                ListNode last = list2;
                list2 = list2.next;
                last.next = list1;
            }
        }
        return newHead;
    }
}
