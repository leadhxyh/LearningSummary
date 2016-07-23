/**
 *	����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 */

/**
 *	˼·���������
 */

public class Solution {
    
    ArrayList<TreeNode> list = new ArrayList();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k <= 0)
            return null;
        
        KthNodeCore(pRoot);
        
        if (list.size() < k)
            return null;
        return list.get(k - 1);
    }
    
	void KthNodeCore(TreeNode pRoot) {
        if (pRoot == null) 
            return;
        KthNodeCore(pRoot.left);
        list.add(pRoot);
        KthNodeCore(pRoot.right);
    }

}
