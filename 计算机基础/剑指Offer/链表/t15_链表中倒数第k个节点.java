/**
 *	输入一个链表，输出该链表中倒数第k个结点。
 */

/**
 *	特殊值测试：1、头指针为空 2、总结点数少于k 3、k等于0
 */

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
       
        ListNode ans =  head;
        
		if (head == null || k < 1) {
            return null;
        }
        int i = k;
        //head先前进k-1个节点
        while (i > 1 && head.next != null) {
            head = head.next;
            i--;
        }
        //节点总数不够
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
