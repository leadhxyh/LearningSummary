/**
 *	汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
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
