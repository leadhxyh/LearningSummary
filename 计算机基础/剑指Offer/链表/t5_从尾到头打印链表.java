/**
 *	����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ�� 
 */

import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursivePrint(listNode);
        return list;
    }
    
    public void recursivePrint(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        recursivePrint(listNode.next);
        list.add(listNode.val);
    }
}
