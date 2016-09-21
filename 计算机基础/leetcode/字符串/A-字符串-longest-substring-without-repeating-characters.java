/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *	
 */

/*
 *	思路：开始下标i从0~s.length-1, 寻找以i开头的字符串中的最长不重复串
 *	用一个set保存所以已经扫描过的字符，若当前j对应的字符已经出现，说明
 *	s[i~j-1]是所有以i开头的子串中最长的,记录该长度。
 *	时间复杂度：O(n^2)
 */

import java.util.*;
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
    	if (s.length() == 0)
    		return 0;
    	int max = 1;

    	for (int i = 0; i < s.length() - 1; i++) {
    		Set<Character> set = new HashSet<Character>();
    		set.add(s.charAt(i));
    		int j = i + 1;
    		for (; j < s.length() && !set.contains(s.charAt(j)); j++) {
    			set.add(s.charAt(j));
    		}
    		if (j - i > max) {
    			max = j - i;
    		}
    	}
    	return max;
    }
}
