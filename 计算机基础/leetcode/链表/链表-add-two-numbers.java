/*
 *	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        int val = 0;
        int carry = 0;
        ListNode sumHead = null;
        ListNode cur = null;
        //有一个为空时，停止
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(val);
            if (sumHead == null) {
                sumHead = newNode;
                cur = sumHead;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //处理链表的余下部分
        if (l1 != null) {
            cur.next = l1;
            while (l1 != null) {
				int sum = l1.val + carry;
                l1.val = sum % 10;
                carry = sum / 10;
                cur = l1;
                l1 = l1.next;
            }
        } else if (l2 != null) {
            cur.next = l2;
            while (l2 != null) {
                int sum = l2.val + carry;
                l2.val = sum % 10;
                carry = sum / 10;
                cur = l2;
                l2 = l2.next;
            }
        }
        
		if (carry == 1) {
                ListNode last = new ListNode(1);
                cur.next = last;
                cur = last;
        }
        
        return sumHead;
    }
}
