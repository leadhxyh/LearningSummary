/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */

/**
 * 思路：使用三个指针last,head,next，分别指向当前节点前一个节点，当前节点，当前节点下一个节点。初始时，last指向null。时间复杂度：O(n)
 * 特殊值测试：1、head为空 2、只有一个节点
 */


public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) 
            return null;

        ListNode last = null;
        ListNode next = null;
		while (head != null) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
            if (head == null) {
                return last;
            }
        }
        return null;
        
    }
}
