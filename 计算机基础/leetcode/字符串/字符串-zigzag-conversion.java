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
 * 思路：指定n行字符串，将指定的字符加到对应的字符串的后面，最后将每一行字符串相连。
 * 也就是寻找将字符串中字符的下标映射到行号的关系。注意到每次竖直向下然后斜向上的个数是固定值（2*nRow-2），可以用这个规律定位.
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
