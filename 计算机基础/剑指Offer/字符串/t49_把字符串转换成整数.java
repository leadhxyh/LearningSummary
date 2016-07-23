/**
 *	将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 */

/**
 *	特殊值测试：1、溢出返回0， 2、遇到非法字符返回0
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
