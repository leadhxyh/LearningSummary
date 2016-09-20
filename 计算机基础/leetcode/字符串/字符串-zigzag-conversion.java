/*
 *	The string"PAYPALISHIRING"is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line:"PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3)should return"PAHNAPLSIIGYIR".
 */

/*
 * ˼·��ָ��n���ַ�������ָ�����ַ��ӵ���Ӧ���ַ����ĺ��棬���ÿһ���ַ���������
 * Ҳ����Ѱ�ҽ��ַ������ַ����±�ӳ�䵽�кŵĹ�ϵ��ע�⵽ÿ����ֱ����Ȼ��б���ϵĸ����ǹ̶�ֵ��2*nRow-2����������������ɶ�λ.
 */

public class Solution {
    public String convert(String s, int nRows) {
    	if (s.length() == 0 || nRows == 1)
    		return s;
        StringBuilder[] sbs = new StringBuilder[nRows];
        for (int i = 0; i < sbs.length; i++)
        	sbs[i] = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	int x = i % (2*nRows - 2);
        	if (x < nRows) {
        		char c = s.charAt(i);
        		sbs[x].append(c);
        	} else {
				sbs[2 * nRows - 2 - x].append(s.charAt(i));
			}
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
        	ans.append(sbs[i]);
        }
        return ans.toString();
        
    }
}
