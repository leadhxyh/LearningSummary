/*
 *	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
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
