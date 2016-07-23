/*
 *	����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min����
 */

public class Solution {

    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> cache = new Stack<Integer>();
    
    public void push(int node) {
        s.push(node);
        if (cache.isEmpty() || node < cache.peek()) {
            cache.push(node);
        }
    }
    
    public void pop() {
        if (s.pop() == cache.peek()) {
            cache.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int min() {
        return cache.peek();
    }
}
