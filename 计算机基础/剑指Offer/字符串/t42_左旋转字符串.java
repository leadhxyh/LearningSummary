/**
 *	�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 */

public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null) 
            return null;
        if (str.length() == 0)
            return str;
        char[] s = str.toCharArray();
        
        int len = str.length();
        int k = n % len;
        reverse(s, 0, k - 1);
        reverse(s, k, len - 1);
        reverse(s, 0, len - 1);
        
        return String.valueOf(s);
    }
    
    public void reverse(char[] s, int index1, int index2) {
        char tem = s[index1];
        while (index1 < index2) {
            tem = s[index1];
            s[index1] = s[index2];
           	s[index2] = tem;
            index1++;
            index2--;
        }
    }
}
