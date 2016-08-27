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
 *	˼·��dp�⡣
 *	״̬���壺dp[i][j]��ʾs1[0 ~ i-1]��s2[0 ~ j-1]��������s3[0 ~ i+j-1]
 *	���ƹ�ʽ��dp[i][j]Ϊtrue ���ҽ��� s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]  �� s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]
 *	��ʼ״̬��dp[i][0]Ϊtrue ���ҽ��� s1[0 ~ i] �� ��s3��ͷ���Ӵ�, dp[0][j]Ϊtrue ���ҽ��� s2[0 ~ j] ���� s3��ͷ���Ӵ�
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		//s1��s2���ȺͲ���s3��ȷ���false
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
