/*
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬�����������е�����Ե�������
 */

public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        
        return inversePairsCore(array, 0, array.length - 1);
        
    }
    
	/*
	 * ������ְ��1�����ظò��ֵ����������2.�Ըò��������������
	 */
    public int inversePairsCore(int[] array, int index1, int index2) {
		//��ֹ����
        if (index1 == index2) {
            return 0;
        }
        int mid = (index1 + index2) / 2;

		//�ݹ���벿��
        int leftCount = inversePairsCore(array, index1, mid);
		//�ݹ��Ұ벿��
        int rightCount = inversePairsCore(array, mid + 1, index2);
        int[] tem = new int[index2 - index1 + 1];
        int leftP = mid;
        int rightP = index2;
        int newP = tem.length - 1;
		//��������м�¼�������
        int currentCount = 0;
        while (leftP >= index1 && rightP > mid) {
            if (array[leftP] > array[rightP]) {
                tem[newP--] = array[leftP--];
                currentCount += (rightP - mid);
            } else {
                tem[newP--] = array[rightP--];
            }
        }
        while (leftP >= index1) {
            tem[newP--] = array[leftP--];
        }
        while (rightP > mid) {
            tem[newP--] = array[rightP--];
        }
        
        for (int i = 0; i < tem.length; i++) {
            array[index1 + i] = tem[i];
        }
        return leftCount + rightCount + currentCount;
    }
}
