/*
 *	Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */

/*
 *	ʱ�临�Ӷȣ�O(n^2)
 *	˼·����̬�滮��dp[i]�����Ӵ�s[0~i-1]����С�и�����dp[i]����min(d[j] + 1)�����Ӵ�s[j ~ i-1]�ǻ���(0<= j<= i-1)��dp[s.length()]���ǽ�
 */

public class Solution {
	public  int minCut(String s) {
		int l = s.length();
		//��̬�滮�����Ӵ�s[i-j]�Ƿ��ǻ���
		boolean[][] isPal = new boolean[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++)
				isPal[i][j] = false;
		}
		for (int i = 0; i < l; i++) {
			for (int j = i; j >= 0; j--) {
				//s[i]==s[j] �� s[j+1, i-1]�ǻ���(abba)��i��j���벻����2(a��aa��aba)
				if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || isPal[j+1][i-1]))
					isPal[j][i] = true;
			}
		}
		
		//dp[i]�����Ӵ�s[0~i-1]����С�и���
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		//dp[i]����min(d[j] + 1)�����Ӵ�s[j ~ i-1]�ǻ���(0<= j<= i-1)
		for (int i = 1; i <= l; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				//�Ұ벿���ǻ���
				if (isPal[j][i-1] && dp[j] + 1 < min) {
					min = dp[j] + 1;
				}
			}
			dp[i] = min;
		}
		return dp[s.length()];
	}
}
