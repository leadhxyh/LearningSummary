/*
 *	输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 */

/*
 *	思路：递归，明确函数功能
 *	特殊值测试：
 *	1、			10			2、      null          3、     10
 *			   /  \                                       /  \
 *			null   11                                    9    11
 *
 */

public class Solution {

    //将以pRootOfTree为根的树转换为双向链表，返回链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //递归左半部分
        TreeNode left = Convert(pRootOfTree.left);
        
		//左半部分返回可能为空，若为空则指定当前节点pRootOfTree为链表头
        if (left != null) {
        	TreeNode last = left;
       		while (last.right != null) {
            	last = last.right;
        	}
            last.right = pRootOfTree;
            pRootOfTree.left = last;

        } else {
            left = pRootOfTree;
        }
        
		//递归右半部分
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
   
        return left;
    }    
}
