/*
 *	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length - 1);
    }
    
    public TreeNode convert(int[] num, int index1, int index2) {
        //�ݹ����
        if (index1 > index2) {
            return null;
        }
        if (index1 == index2) {
            return new TreeNode(num[index1]);
        }

        //�м�ڵ���Ϊ���ڵ�
        int rootIndex = (index1 + index2) / 2;
        if (((index2 - index1) & 0x1) == 1) {
            rootIndex++;
        }
        
		TreeNode root = new TreeNode(num[rootIndex]);
        //�ݹ���������Ϊ������
        root.left = convert(num, index1, rootIndex - 1);
        //�ݹ��ұ���Ϊ������
        root.right = convert(num, rootIndex + 1, index2);
        return root;
    }
}
