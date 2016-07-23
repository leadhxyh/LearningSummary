/*
 *	输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

public class Solution {
    
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack();
        int j = 0;
      	for (int i = 0; i < popA.length; i++) {
            if (!s.isEmpty() && s.peek() == popA[i]) {
                s.pop();
                continue;
            }
            
            while (j < popA.length && popA[i] != pushA[j]) {
                s.push(pushA[j]);
                j++;
            }
            if (j == popA.length)
                return false;
            else
                j++;
        }
        return true;
    }
}
