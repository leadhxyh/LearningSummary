/*
 *	���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
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
