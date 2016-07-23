/*
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��
 */

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        } 

        int[] f = new int[len];
        f[0] = array[0];
        int max = f[0];
        for (int i = 1; i < len; i++) {
            if (f[i-1] > 0) {
                f[i] = f[i - 1] + array[i];
            } else {
                f[i] = array[i];
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        
        return max;
    }
}
