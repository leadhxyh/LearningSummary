/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *	
 */

/*
 *	˼·�����ַ���������Ĵ���dp�⡣ʱ�临�Ӷ�O(n2)
 *  ��һ������dp��¼�Ӵ�s[i~j]�Ƿ��ǻ��Ĵ�O(n2)��Ȼ�����ÿ���Ӵ�Ѱ������Ĵ���
 *  ״̬����:dp[i][j]��ʾs[i~j]�Ƿ��ǻ���
 *  ״̬���̣�dp[i][j] == true;		i==j
 *            dp[i][j] = s[i][j];	i+1 == j(���������ַ����Ӵ���ֻ���ж��������ַ��Ƿ���ȾͿ��ж��Ƿ��ǻ���)
 *            dp[i][j] = (s[i] == s[j] && dp[i+1][j-1];
 */

public class Solution {
    public static String longestPalindrome(String s) {
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	isPd(dp, s);
    	
    	String ans = s;
    	int longest = -1;
        for (int i = 0; i < s.length(); i++) {
        	for (int j = i + 1; j < s.length(); j++) {
        		if (dp[i][j] && (j - i + 1) > longest) {
        			longest = j - i + 1;
        			ans = s.substring(i, j + 1);
        		}
        			
        	}
        }
        return ans;
    }
    
    public static void isPd(boolean[][] dp, String s) {
    	int row = dp.length;
    	int col = dp[0].length;
    	for (int j = 0; j < col; j++) {
    		for (int i = 0; i <= j; i++) {
    			if (i == j)
    				dp[i][j] = true;
    			else if (j == i+1)
    				dp[i][j] = (s.charAt(i) == s.charAt(j));
    			else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
				}
    		}
    	}
    }
}
