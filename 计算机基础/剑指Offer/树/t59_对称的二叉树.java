/*
 *	��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 */

/*
 *	˼·���ݹ�ʵ��
 */

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        return isSymmetricalCore(pRoot.left, pRoot.right);
    }
    
    boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        if (left == null && right == null)		//��Ϊ��
            return true;
        if (left == null || right == null)		//����һ������
            return false;
        return left.val == right.val			//����������
            && isSymmetricalCore(left.left, right.right) 
            && isSymmetricalCore(left.right, right.left);
    }
}
