/**
 *	请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class Solution {
    int len = 0;
    int index = 0;
    char[] s;
    boolean numeic = true;
    public boolean isNumeric(char[] str) {
        if (str == null)
			return false;

		len = str.length;
		s = str;

		if ((str[0] == '+') || (str[0] == '-'))
			index++;

		// 扫描到下一个非数字字符
		eatDigit();

		if (index == len) { // 整数,3
			numeic = true;
		} else { // 小数
			if (s[index] == '.') {
				index++;
				eatDigit();
				if (index == len) { // 3.14
					numeic = true;
				} else if (s[index] == 'e' || s[index] == 'E') { // 3.14e+4
					numeic = isExponential();
				} else {
					numeic = false;
				}

			} else if (s[index] == 'e' || s[index] == 'E') {
				numeic = isExponential();
			} else {
				numeic = false;
			}
		}

		return numeic;
    }
    
    boolean isExponential() {
        if (s[index] != 'e' && s[index] != 'E')
            return false;
        index++;
        
        if (index < len && (s[index] == '+' || s[index] == '-'))
			index++;
       
        return (eatDigit() && index == len);
    }
    
    //将index推进到非数字字符或结尾，至少吃掉一个数字返回true
    boolean eatDigit() {
        boolean isDigit = false;
        while (index < len && isDigit(s[index])) {
			index++;
			isDigit = true;
        }
        return isDigit;
    }
    
    boolean isDigit(char c) {
        return ((c >= '0') && (c <= '9'));
    }
}
