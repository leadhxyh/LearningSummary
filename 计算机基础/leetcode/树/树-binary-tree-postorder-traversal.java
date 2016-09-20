/*
 *	Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3
 */

/*
 *	思路：二叉树的后序迭代遍历。
 *	将根节点入栈;
 *		while (栈非空)：
 *			若栈顶元素无左右孩子 或 栈顶元素左右孩子已访问：
 *				出栈并访问
 *			否则：
 *				若左孩子或右孩子非空，将其入栈
 */	

import java.util.*;
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        ArrayList<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        s.push(root);
        
        while (!s.isEmpty()) {
            cur = s.peek();
            if ((cur.left == null && cur.right == null) 
                || (pre != null && (pre == cur.left || pre == cur.right))) {
                pre = cur;
                s.pop();
                ret.add(pre.val);
            }
            else {
                if (cur.right != null) {
                    s.push(cur.right);
                }
                if (cur.left != null) {
                    s.push(cur.left);
                }
            }
        }
        
        return ret;
  
