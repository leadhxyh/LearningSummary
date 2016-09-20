/*
 * http://www.nowcoder.com/practice/e3f491c56b7747539b93e5704b6eca40?tpId=46&tqId=29094&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */

/*
 *	·ÖÎö£ºhttp://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 *
 */

import java.util.*;
public class Solution {
	public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
