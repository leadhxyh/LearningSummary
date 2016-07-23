/*
 *	����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 *
 */

/*
 *	˼·���ݹ飬��ȷ��������
 *	����ֵ���ԣ�
 *	1��			10			2��      null          3��     10
 *			   /  \                                       /  \
 *			null   11                                    9    11
 *
 */

public class Solution {

    //����pRootOfTreeΪ������ת��Ϊ˫���������������ͷ���
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //�ݹ���벿��
        TreeNode left = Convert(pRootOfTree.left);
        
		//��벿�ַ��ؿ���Ϊ�գ���Ϊ����ָ����ǰ�ڵ�pRootOfTreeΪ����ͷ
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
        
		//�ݹ��Ұ벿��
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
   
        return left;
    }    
}
