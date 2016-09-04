/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.
 *	
 */

/*
 * ����������1,1,2,3
 * 1, 1, 2, 2, 3
 * 1, 2, 3, 3, 3
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        //�����ƽڵ���Ϊͷ���
        ListNode dumy = new ListNode(Integer.MAX_VALUE);
        dumy.next = head;
        ListNode tmp = dumy;
        while (tmp != null) {
            ListNode next = nextNewNode(tmp.next);
            tmp.next = next;
            tmp = next;
        }
        return dumy.next;
        
    }
    
    //cur�ڵ��ĵ�һ���½ڵ㣬������null
    ListNode nextNewNode(ListNode cur) {
        while (needDelete(cur)) {
		  int val = cur.val;
      	  while (cur != null && cur.val == val)
           	 cur = cur.next;           
        }
        return cur;

    }
    //�жϵ�ǰ�ڵ��Ƿ���Ҫ����
    boolean needDelete(ListNode cur) {
        if (cur != null && cur.next != null && cur.val == cur.next.val)
            return true;
        return false;
    }
}
