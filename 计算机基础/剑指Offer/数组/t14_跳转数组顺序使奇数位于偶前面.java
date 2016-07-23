/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */

public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0)
            return;
        int[] tem = new int[array.length];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x01) == 1) {
                tem[k++] = array[i];
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x01) == 0) {
                tem[k++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tem[i];
        }
    }
}
