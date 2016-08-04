/*
 *Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

/*
 *	˼·���沨�������㷨��
1��ѭ��ɨ���﷨��Ԫ����Ŀ��
2�����ɨ�����Ŀ�ǲ�����������ѹ���������ջ����ɨ����һ����Ŀ��
3�����ɨ�����Ŀ��һ����Ԫ����������ջ�Ķ�������������ִ�и����㡣
4�����ɨ�����Ŀ��һ��һԪ����������ջ����ϲ�����ִ�и����㡣
5��������������ѹ���ջ��
6���ظ�����2-5����ջ�м�Ϊ���ֵ��
 */

import java.util.*;
public class Solution {
    
    public int evalRPN(String[] tokens) {
    	Stack<Integer> s = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") 
                || token.equals("-") 
                || token.equals("*")
               || token.equals("/")) {
                int a = s.pop();
                int b = s.pop();
                if (token.equals("+")) {
                    s.push(a + b);
                } else if (token.equals("-")) {
                    s.push(b - a);
                } else if (token.equals("*")) {
                    s.push(a * b);
                } else {
                    s.push(b / a);
                }
            } else {
                s.push(Integer.valueOf(token));
            }
        }
        return s.pop();
    }
}
