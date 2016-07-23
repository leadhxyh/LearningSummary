/**
 * �������������ҳ����ǵĵ�һ��������㡣
 */

/**
 * ����ֵ���ԣ���һ������Ϊ��
 * ����ֵ���ԣ��޹�������
 */

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        if (len1 == 0 || len2 == 0) {
            return null;
        }
        //���������ֵ
        int dif = len1 > len2 ? len1 - len2 : len2 - len1;
        //������������dif��
        if (len1 > len2) {
            for (int i = 0; i < dif; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < dif; i++) {
                pHead2 = pHead2.next;
            }
        }
        
        //һ����ǰ��
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        
        if (pHead1 == null || pHead2 == null) {
            return null;
        } else {
            return pHead1;
        }
        
    }
    
    //��ȡ������
    int getLength(ListNode pHead) {
        int len = 0;
        while (pHead != null) {
            len++;
            pHead = pHead.next;
        }
        return len;
    }
}
