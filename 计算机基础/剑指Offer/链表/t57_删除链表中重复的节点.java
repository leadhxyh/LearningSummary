��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5

/**
* ��������: 1->1->2->3->3
**/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            boolean needDelete = false;
            //�ж��Ƿ�ɾ����ǰ�ڵ�
            if (next != null && cur.val == next.val)
                needDelete = true;
            if (!needDelete) {
                pre = cur;
                cur = next;
            } else {
                //cur���ƣ�ֱ��Ϊnull��ָ���ظ�Ԫ��
                while (cur.next != null && cur.val == next.val) {
                    cur = next;
                    next = cur.next;
                }
                cur = next;
                //����pre
                if (pre == null) {
                    pHead = cur;
                } else {
                    pre.next = cur;
                }
                
            }
        }
        return pHead;
    }
}


//��ȥ�ظ�Ԫ�أ�������һ���ظ�Ԫ�ذ汾
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead == null) {
            return null;
        }
        ListNode cur = pHead;
        while (cur.next != null) {
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                 	cur.next = cur.next.next;   
                } else {
                    break;
                }
            }
            cur = cur.next;
        }
        return pHead;
    }
}
