/**
 *	����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */

/**
 *	˼·�����´����Ľڵ���ӵ�ԭ�ڵ�ĺ��棬���һ�����롣ʱ�临�Ӷ�O(n);
 *	����������ԣ�1��ͷ���ָ��null 2.ֻ��һ���ڵ�
 */


public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
   		if (pHead == null) {
            return null;
        }    
        //�������Ľڵ���ӵ�ԭ�ڵ�ĺ���
        RandomListNode pCur = pHead;
        while (pCur != null) {
            RandomListNode newNode = new RandomListNode(pCur.label);
            RandomListNode last = pCur;
            pCur = pCur.next;
            newNode.next = last.next;
            last.next = newNode;
        }
        
        //����randomָ��Ŀ���
        pCur = pHead;
        while (pCur != null) {
            if (pCur.random != null) {
             	pCur.next.random = pCur.random.next;   
            }
            pCur = pCur.next.next;
        }
        
        //�����ƵĽڵ��ԭ�����з���
        pCur = pHead;
        RandomListNode pNewHead = pCur.next;
        RandomListNode pNewCur = pNewHead;
        while (pCur != null) {
            pCur.next = pNewCur.next;
            if (pNewCur.next == null) {
             	return pNewHead;
            }
            pNewCur.next = pNewCur.next.next;   
            pCur = pCur.next;
            pNewCur = pNewCur.next;
        }
        
        return pNewHead;
    }
    
}
