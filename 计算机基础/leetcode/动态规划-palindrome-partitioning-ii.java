/*
 *	Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */

/*
 *	时间复杂度：O(n^2)
 *	思路：动态规划，dp[i]代表子串s[0~i-1]的最小切割数，dp[i]等于min(d[j] + 1)其中子串s[j ~ i-1]是回文(0<= j<= i-1)，dp[s.length()]就是解
 */

public class Solution {
	public  int minCut(String s) {
		int l = s.length();
		//动态规划计算子串s[i-j]是否是回文
		boolean[][] isPal = new boolean[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++)
				isPal[i][j] = false;
		}
		for (int i = 0; i < l; i++) {
			for (int j = i; j >= 0; j--) {
				//s[i]==s[j] 且 s[j+1, i-1]是回文(abba)或i和j距离不大于2(a或aa或aba)
				if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || isPal[j+1][i-1]))
					isPal[j][i] = true;
			}
		}
		
		//dp[i]代表子串s[0~i-1]的最小切割数
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		//dp[i]等于min(d[j] + 1)其中子串s[j ~ i-1]是回文(0<= j<= i-1)
		for (int i = 1; i <= l; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				//右半部分是回文
				if (isPal[j][i-1] && dp[j] + 1 < min) {
					min = dp[j] + 1;
				}
			}
			dp[i] = min;
		}
		return dp[s.length()];
	}
}
