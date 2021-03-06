/**
 *	输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */

/**
 *	时间复杂度：O(n), 递归计算
 *	特殊值测试：1、链表都为空 2、其中一个为空
 */

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode newHead = null;
		if (list1.val <= list2.val) {
            newHead = list1;
            newHead.next = Merge(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next =  Merge(list1, list2.next);
        }
        return newHead;
    }
}
