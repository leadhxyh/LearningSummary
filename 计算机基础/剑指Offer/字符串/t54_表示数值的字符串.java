/**
 *	��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
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

		// ɨ�赽��һ���������ַ�
		eatDigit();

		if (index == len) { // ����,3
			numeic = true;
		} else { // С��
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
    
    //��index�ƽ����������ַ����β�����ٳԵ�һ�����ַ���true
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
