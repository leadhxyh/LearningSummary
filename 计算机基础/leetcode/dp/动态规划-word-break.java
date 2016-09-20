/*
 *	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s ="leetcode",
dict =["leet", "code"].
Return true because"leetcode"can be segmented as"leet code".
 */

/*
 *	˼·��dp
 *	1��dp[i]��ʾs[0-i]���Ա��и�
 *	2��dp[i]Ϊtrue ���ҽ��� ����0<=K<=i,dp[k]==true���Ӵ�s[k-i)���ֵ���
 */

import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}
