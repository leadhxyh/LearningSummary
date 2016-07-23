/*
 *	����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡���������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
