/*
 *	给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/*
 *					8
 *				   / \
 *				  6   10
 *				 / \  /	\
 *			    5   7 9  11
 *  情况1：当前节点有右节点如6
 *  情况2：当前节点无右节点，是父节点的左节点，如5
 *  情况3：当前节点无右节点，是父节点的右节点，如7
 */

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null || (pNode.next == null && pNode.right == null))
            return null;
        
        if (pNode.right != null)	//情况1：当前节点有右节点 
        {
            TreeLinkNode tem = pNode.right;
            while (tem.left != null) {
                tem = tem.left;
            }
            return tem;
        }
        
        if (isLeft(pNode)) 		//情况二：当前节点无右节点，是父节点的左节点
            return pNode.next;
        
        
        //情况三：当前节点无右节点，是父节点的右节点
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
