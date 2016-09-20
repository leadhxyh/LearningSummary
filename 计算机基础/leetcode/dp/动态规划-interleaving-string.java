/*
 *	Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
For example,
Given:
s1 ="aabcc",
s2 ="dbbca",
When s3 ="aadbbcbcac", return true.
When s3 ="aadbbbaccc", return false.
 */

/*
 *	思路：dp题。
 *	状态定义：dp[i][j]表示s1[0 ~ i-1]和s2[0 ~ j-1]可以生成s3[0 ~ i+j-1]
 *	递推公式：dp[i][j]为true 当且仅当 s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]  或 s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]
 *	初始状态：dp[i][0]为true 当且仅当 s1[0 ~ i] 是 以s3开头的子串, dp[0][j]为true 当且仅当 s2[0 ~ j] 是以 s3开头的子串
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		//s1和s2长度和不与s3相等返回false
        if (s1.length() + s2.length() != s3.length())
            return false;
        
        int len1 = s1.length() + 1;
        int len2 = s2.length() + 1;
        boolean[][] dp = new boolean[len1][len2];
        for (int i = 1; i < len1; i++) {
        	dp[i][0] = s3.startsWith(s1.substring(0, i));
        }
        for (int j = 1; j < len2; j++) {
        	dp[0][j] = s3.startsWith(s2.substring(0, j));
        }
        dp[0][0] = true;
        for (int i = 1; i < len1; i++) {
        	for (int j = 1; j < len2; j++) {
        		if ( (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) 
        				|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])) {
        			dp[i][j] = true;
        		}
        	}
        }
        
        return dp[len1 - 1][len2 - 1];
    }
}
