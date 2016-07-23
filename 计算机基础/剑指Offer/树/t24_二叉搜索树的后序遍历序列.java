/*
 *	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verifyCore(sequence, 0, sequence.length - 1);
    }
    
    boolean verifyCore(int[] seq, int index1, int index2) {
        if (index1 >= index2)
            return true;
        int root = seq[index2];
        int mid = index2 - 1;
        
        //从后向前寻找第一个小于根节点的元素下标
        while (mid >= index1 && seq[mid] > root) {
            mid--;
        }
        //若前半段有大于根元素的节点直接返回false
        for (int i = index1; i <= mid; i++) {
            if (seq[i] > root) {
             	return false;   
            }
        }
        //若后半段有小于根元素的节点直接返回false
        for (int i = mid + 1; i <= index2 - 1; i++) {
            if (seq[i] < root) {
             	return false;   
            }
        }
        //对前后两段递归计算
        return verifyCore(seq, index1, mid) && verifyCore(seq, mid + 1, index2 - 1);
    }
}
