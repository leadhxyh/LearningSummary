/*
 *	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
 */

/*
 * 类似于贪心
 * 时间复杂度:O(n)
 */


public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        //i从头向尾扫描，j从后向前扫描
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            //当height[i] < height[j]时有两个选择，i前进一个，或j后退一个
            //显然区间[i+1~j]中更有可能去的最大值
            if (height[i] < height[j])
                i++;
            else 
                j--;
        }
        return max;
    }
}
