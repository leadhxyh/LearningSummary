/*
 *���������Ķ�����������任ΪԴ�������ľ��� 
 *��������:
 *�������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 *	
 *
 */

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;  
    }
}
