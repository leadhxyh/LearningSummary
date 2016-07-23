/*
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
����һ����������������һ����ת�������ת�������СԪ�ء�
��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */

/*
 * ���ܲ��ԣ�
 * �߽���ԣ�2,3,4,5;   1
 * ����ֵ���ԣ�null
 */
import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	if (array == null || array.length == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (array[index1] >= array[index2]) {		//����Ϊ���ݼ�ʱ����
            if (index2 - index1 == 1 ) {
                mid = index2;
                break;
            }
            mid = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[index1] == array[mid]) {
                return minInOrder(array, index1, index2);
            }
            if (array[mid] >= array[index1]) {
                index1 = mid;
            } else if (array[mid] <= array[index2]) {
                index2 = mid;
            }
        }
        
        return array[mid];
    }
    
  	public int minInOrder(int[] array, int index1, int index2) {
    	int result = array[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if (array[i] < result){
                result = array[i];
            }
        }
        return result;
  	}
}
