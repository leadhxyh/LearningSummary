/*
 *	Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

/*
 *	注意点：注意这个情况：		1
 *							   /
 *							 2
 */

public class Solution {
    public int run(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right != null) {
            return run(root.right) + 1;
        }
        if (root.right == null && root.left != null) {
            return run(root.left) + 1;
        }
        int left = run(root.left);
        int right = run(root.right);
        return 1 + (left < right ? left : right);
    }
}
