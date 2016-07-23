在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

/**
* 测试用例: 1->1->2->3->3
**/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            boolean needDelete = false;
            //判读是否删除当前节点
            if (next != null && cur.val == next.val)
                needDelete = true;
            if (!needDelete) {
                pre = cur;
                cur = next;
            } else {
                //cur后移，直到为null或指向不重复元素
                while (cur.next != null && cur.val == next.val) {
                    cur = next;
                    next = cur.next;
                }
                cur = next;
                //更新pre
                if (pre == null) {
                    pHead = cur;
                } else {
                    pre.next = cur;
                }
                
            }
        }
        return pHead;
    }
}


//除去重复元素，仅保留一个重复元素版本
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead == null) {
            return null;
        }
        ListNode cur = pHead;
        while (cur.next != null) {
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                 	cur.next = cur.next.next;   
                } else {
                    break;
                }
            }
            cur = cur.next;
        }
        return pHead;
    }
}
