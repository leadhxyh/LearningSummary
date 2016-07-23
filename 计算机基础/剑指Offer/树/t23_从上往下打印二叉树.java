/*
 *	从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

/*
 *	思路：二叉树层序遍历
 */

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        TreeNode cur = null;
        while (queue.size() != 0) {
            cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        
        return list;
    }
}
