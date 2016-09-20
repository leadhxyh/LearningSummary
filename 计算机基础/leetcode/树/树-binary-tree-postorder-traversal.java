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
 *	˼·���������ĺ������������
 *	�����ڵ���ջ;
 *		while (ջ�ǿ�)��
 *			��ջ��Ԫ�������Һ��� �� ջ��Ԫ�����Һ����ѷ��ʣ�
 *				��ջ������
 *			����
 *				�����ӻ��Һ��ӷǿգ�������ջ
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
  
