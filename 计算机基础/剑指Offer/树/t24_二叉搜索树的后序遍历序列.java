/*
 *	����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
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
        
        //�Ӻ���ǰѰ�ҵ�һ��С�ڸ��ڵ��Ԫ���±�
        while (mid >= index1 && seq[mid] > root) {
            mid--;
        }
        //��ǰ����д��ڸ�Ԫ�صĽڵ�ֱ�ӷ���false
        for (int i = index1; i <= mid; i++) {
            if (seq[i] > root) {
             	return false;   
            }
        }
        //��������С�ڸ�Ԫ�صĽڵ�ֱ�ӷ���false
        for (int i = mid + 1; i <= index2 - 1; i++) {
            if (seq[i] < root) {
             	return false;   
            }
        }
        //��ǰ�����εݹ����
        return verifyCore(seq, index1, mid) && verifyCore(seq, mid + 1, index2 - 1);
    }
}
