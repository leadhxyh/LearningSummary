/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *	
 */

/*
 *	˼·����ʼ�±�i��0~s.length-1, Ѱ����i��ͷ���ַ����е�����ظ���
 *	��һ��set���������Ѿ�ɨ������ַ�������ǰj��Ӧ���ַ��Ѿ����֣�˵��
 *	s[i~j-1]��������i��ͷ���Ӵ������,��¼�ó��ȡ�
 *	ʱ�临�Ӷȣ�O(n^2)
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
