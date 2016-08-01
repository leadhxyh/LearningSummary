/*
 *	����һ���������飬����ͨ�����ö��ֲ��ҵķ�ʽ����λĳһԪ�أ����д���ֲ��ҵ��㷨���������в���ָ��Ԫ�ء�
����һ����������A�����Ĵ�Сn��ͬʱ����Ҫ���ҵ�Ԫ��val���뷵�����������е�λ��(��0��ʼ)���������ڸ�Ԫ�أ�����-1������Ԫ�س��ֶ�Σ��뷵�ص�һ�γ��ֵ�λ�á�
����������
[1,3,5,7,9],5,3
���أ�1
 */

import java.util.*;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        // write code here
        int index = -1;
		int index1 = 0;
        int index2 = n - 1;
        while (index1 <= index2) {
            int mid = (index1 + index2) / 2;
            if (A[mid] == val) {
                int i = mid;
             	while (i > 0 && A[i - 1] == val) {
                    i--;
                }
                index = i;
                break;
            } else if (A[mid] < val) {
                index1 = mid + 1;
            } else {
                index2 = mid - 1;
            }
        }
        
        return index;
    }
}
