/**
 *	����һ����������������е�����k����㡣
 */

/**
 *	����ֵ���ԣ�1��ͷָ��Ϊ�� 2���ܽ��������k 3��k����0
 */

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
       
        ListNode ans =  head;
        
		if (head == null || k < 1) {
            return null;
        }
        int i = k;
        //head��ǰ��k-1���ڵ�
        while (i > 1 && head.next != null) {
            head = head.next;
            i--;
        }
        //�ڵ���������
        if (i != 1) {
            return null;
        }
        
        while (head.next != null) {
            head = head.next;
            ans = ans.next;
        }
       
        return ans;
        
    }
}
