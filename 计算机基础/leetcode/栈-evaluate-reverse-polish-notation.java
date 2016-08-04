/*
 *Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

/*
 *	思路：逆波兰计算算法：
1、循环扫描语法单元的项目。
2、如果扫描的项目是操作数，则将其压入操作数堆栈，并扫描下一个项目。
3、如果扫描的项目是一个二元运算符，则对栈的顶上两个操作数执行该运算。
4、如果扫描的项目是一个一元运算符，则对栈的最顶上操作数执行该运算。
5、将运算结果重新压入堆栈。
6、重复步骤2-5，堆栈中即为结果值。
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
