/*
 *
	��������10���ˣ�һ�ֶ������ƣ�һ�ֲ�������ô��֪������int32����m��n�Ķ����Ʊ��ж��ٸ�λ(bit)��ͬô�� 
	��������:
	1999 2299

	�������:
	7
 */

/*
 *	˼·���Ƚ�m,n���Ȼ�������е�1�ĸ�����ע�⣺>>>������չ���۲����������򸺶��ڸ�λ��0��>>�Ƿ�����չ
 */

public class Solution {
    /**
     * ����������ζ����Ʊ��λ����ͬ������
     * 
     * @param m ����m
     * @param n ����n
     * @return ����
     */
    public int countBitDiff(int m, int n) {
		int dif = m ^ n;
        int count = 0;
        while (dif != 0) {
            if ((dif & 0x01) == 1)
                count++;
            dif >>>= 1;
        }
        return count;
    }
}
