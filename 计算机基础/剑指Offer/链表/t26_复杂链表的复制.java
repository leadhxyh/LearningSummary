/**
 *	输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

/**
 *	思路：将新创建的节点添加到原节点的后面，最后一步分离。时间复杂度O(n);
 *	特殊输入测试：1、头结点指向null 2.只有一个节点
 */


public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
   		if (pHead == null) {
            return null;
        }    
        //将拷贝的节点添加到原节点的后面
        RandomListNode pCur = pHead;
        while (pCur != null) {
            RandomListNode newNode = new RandomListNode(pCur.label);
            RandomListNode last = pCur;
            pCur = pCur.next;
            newNode.next = last.next;
            last.next = newNode;
        }
        
        //进行random指针的拷贝
        pCur = pHead;
        while (pCur != null) {
            if (pCur.random != null) {
             	pCur.next.random = pCur.random.next;   
            }
            pCur = pCur.next.next;
        }
        
        //将复制的节点从原链表中分离
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
