/**
 *	一个链表中包含环，请找出该链表的环的入口结点。
 */

/**
 * 特殊输入：1.无环 2.整个链表为一个环
 */

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) 
            return null;
        if (pHead.next == pHead)
            return pHead;
        //寻找环中的一个节点
        ListNode node = nodeInLoop(pHead);
        if (node == null)
            return null;
     
        //计算环中元素个数
        ListNode node1 = node.next;
        int count = 1;
        while (node1 != node) {
            count++;
            node1 = node1.next;
        }
        //寻找入口
        ListNode ahead = pHead;
        ListNode behind = pHead;
  		for (int i = 0; i < count; i++) {
            ahead = ahead.next;
        }
       	while (ahead != behind) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return ahead;
        
        
    }
    //通过一快一慢两个指针寻找环中的一个节点，无环时返回null
    public ListNode nodeInLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        slow = slow.next;
        fast = fast.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow) 
            return fast;
        else 
            return null;
        
    }
}
