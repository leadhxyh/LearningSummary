/*
 *	请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

/*
 *	思路：递归实现
 */

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        return isSymmetricalCore(pRoot.left, pRoot.right);
    }
    
    boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        if (left == null && right == null)		//都为空
            return true;
        if (left == null || right == null)		//其中一个不空
            return false;
        return left.val == right.val			//两个都不空
            && isSymmetricalCore(left.left, right.right) 
            && isSymmetricalCore(left.right, right.left);
    }
}
