/*
 *	����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */

/*
 *					8
 *				   / \
 *				  6   10
 *				 / \  /	\
 *			    5   7 9  11
 *  ���1����ǰ�ڵ����ҽڵ���6
 *  ���2����ǰ�ڵ����ҽڵ㣬�Ǹ��ڵ����ڵ㣬��5
 *  ���3����ǰ�ڵ����ҽڵ㣬�Ǹ��ڵ���ҽڵ㣬��7
 */

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null || (pNode.next == null && pNode.right == null))
            return null;
        
        if (pNode.right != null)	//���1����ǰ�ڵ����ҽڵ� 
        {
            TreeLinkNode tem = pNode.right;
            while (tem.left != null) {
                tem = tem.left;
            }
            return tem;
        }
        
        if (isLeft(pNode)) 		//���������ǰ�ڵ����ҽڵ㣬�Ǹ��ڵ����ڵ�
            return pNode.next;
        
        
        //���������ǰ�ڵ����ҽڵ㣬�Ǹ��ڵ���ҽڵ�
        TreeLinkNode tem = pNode;
        while (tem.next != null && !isLeft(tem)) {
            tem = tem.next;
        }
        return tem.next;
    }
    
    boolean isLeft(TreeLinkNode pNode) {
        return pNode == pNode.next.left;
    }
    
}
