/**
 *	给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */

/**
 *	思路：中序遍历
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
