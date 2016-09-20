/*
 *	Given a binary tree, return the preorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3
 */

/*
 *	思路：树前序迭代遍历
 */

import java.util.*;
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList();
        if (root == null)
            return ret;
        Stack<TreeNode> s = new Stack();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            ret.add(cur.val);
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return ret;
    }
}
