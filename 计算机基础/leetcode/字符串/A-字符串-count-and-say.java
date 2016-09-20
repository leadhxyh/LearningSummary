/*
 *	The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1is read off as"one 1"or11.
11is read off as"two 1s"or21.
21is read off as"one 2, thenone 1"or1211.
Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.
 */

/*
 * 思路：循环n次，每次计算下一个字符串
 */

public class Solution {
	public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
