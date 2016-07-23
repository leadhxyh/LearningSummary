/*
 *	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0){
        	return null;
        }
        
        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++){
            if (in[i] == pre[0]){
                rootIndex = i;
                break;
            }
        }
        
        int leftNum = rootIndex;
        int rightNum = in.length - rootIndex - 1;
        int[] preLeft = new int[leftNum];
        int[] preRight = new int[rightNum];
        int[] inLeft = new int[leftNum];
        int[] inRight = new int[rightNum];
        
        for (int i = 0; i < rootIndex; i++){
            inLeft[i] = in[i];
        }
        for (int i = rootIndex + 1; i < in.length; i++){
            inRight[i - (rootIndex + 1)] = in[i];
        }
        for (int i = 1; i <= leftNum; i++){
            preLeft[i - 1] = pre[i]; 
        }
        for (int i = leftNum + 1; i < pre.length; i++){
            preRight[i - (leftNum + 1)] = pre[i];
        }
        
        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);
        return root; 
    }
}
