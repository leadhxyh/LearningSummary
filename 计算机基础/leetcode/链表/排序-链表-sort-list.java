/*
 *	Sort a linked list in O(n log n) time using constant space complexity.
 */

/*
 *	˼·������������Ҫע��ĵط���
 *		1.��Ҫ�Զ��巽���жϵݹ��Ƿ��������begin��end֮��ֹͣ�ݹ�
 *		2.���������磺1, 2����Ҫ����nulL
 */

public class Solution {
    
	public  ListNode sortList(ListNode head) {
        if (head == null) 
            return null;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        quickSort(head, end);
        return head;
    }
    
    public  void quickSort(ListNode begin, ListNode end) {
        if (begin != null && end != null && isBefore(begin, end)) {
            
            ArrayList<ListNode> midPair = partition(begin, end);
            
            if (midPair.get(0) != null) {
                quickSort(begin, midPair.get(0));
            }
            
            if (midPair.get(1) != null) {
                quickSort(midPair.get(1), end);
            }
        }
    }
    
	//�ָ������������м�ڵ��ǰһ���ͺ�һ���ڵ�
    public ArrayList<ListNode> partition(ListNode begin, ListNode end) {
        ListNode i = null;
        for (ListNode j = begin; j != end; j = j.next) {
            if (j.val < end.val) {
                if (i == null) {
                    i = begin;
                } else {
                    i = i.next;
                }
                int tem = i.val;
                i.val = j.val;
                j.val = tem;
            }
        }
        int tem = 0;
        ArrayList<ListNode> pair = new ArrayList<ListNode>();
        if (i == null) {
            tem = begin.val;
            begin.val = end.val;
            end.val = tem;
            pair.add(i);
            pair.add(begin.next);
        } else {
			tem = i.next.val;  
            i.next.val = end.val;
        	end.val = tem;
            pair.add(i);
            pair.add(i.next.next);
        }
        return pair;
    }
	
	//�ж�begin�ڵ��Ƿ���end�ڵ�ǰ
    public boolean isBefore(ListNode begin, ListNode end) {
    	while (begin != null) {
    		if (begin == end) {
    			return true;
    		}
    		begin = begin.next;
    	}
    	return false;
    }
}
