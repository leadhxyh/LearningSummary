/**
 *	输入一个链表，从尾到头打印链表每个节点的值。 
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
