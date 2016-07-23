/**
 *	输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

/*
 *	思路：中序遍历
 */

public class Solution {
    ArrayList<ArrayList<Integer>> ret = new ArrayList();
    int sum = 0;
    ArrayList<Integer> path = new ArrayList();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return ret;
        findPathCore(root, target);
        return ret;
    }
    
    //保证root非空
	void findPathCore(TreeNode root, int target) {
		sum += root.val;
        path.add(root.val);
        //叶子节点且值相等
        if (sum == target && root.left == null && root.right == null) {
 
			ArrayList<Integer> tem = (ArrayList<Integer>)path.clone();
            ret.add(tem);	   
        }
        
        if (root.left != null)
        	findPathCore(root.left, target);
        
        if (root.right != null)
        	findPathCore(root.right, target);            
        
        sum -= root.val;
        path.remove(path.size() - 1);
        
    }
}
