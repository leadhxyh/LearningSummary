/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */

/**
 * ˼·����������һ�����ض�����λ�������ȼ�����λ����Ȼ���ж��Ƿ񳬹�������
 */

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //������λ��
        int mid = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index < mid) {
                start = index + 1;
                index = partition(array, start, end);
            } else {
                end = index - 1;
                index = partition(array, start, end);
            }
        }
        int result = array[index];
        
        //����Ƿ񳬹�����
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                time++;
            }
        }
        if (time * 2 <= array.length) {
            return 0;
        } else {
            return result;
        }
    }
    
    public int partition(int[] array, int index1, int index2) {
        int i = index1 - 1;
        for (int j = index1; j < index2 - 1; j++) {
            if (array[j] < array[index2]) {
                i++;
                int tem = array[i];
                array[i] = array[j];
                array[j] = tem;
            }
           
        }
        int t = array[i + 1];
        array[i + 1] = array[index2];
        array[index2] = t;
        return i + 1;
    }
}
