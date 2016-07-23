/**
 *	��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯����
 */

/**
 *	����ֵ���ԣ�1���������0�� 2�������Ƿ��ַ�����0
 */

public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) 
            return 0;
        int sign = 1;
        long num = 0;
        int i = 0;
        char[] s = str.	toCharArray();
        
        if (s[0] == '+') {
            i++;
        } else if (s[0] == '-') {
            sign = -1;
            i++;
        }
        
            for (; i < s.length; i++) {
                if (s[i] >= '0' && s[i] <= '9') {
                    num = num * 10 + sign * (s[i] - '0');
                    if ((sign == 1 && num > 0x7FFFFFFF) || (sign == -1 && num < 0x80000000)) {
                        num = 0;
                        break;
                    }
                } else {
                    num = 0;
                    break;
                }
            }
            
            return (int)num;
        
        
    }
}
