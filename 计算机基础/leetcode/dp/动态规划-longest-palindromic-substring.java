/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *	
 */

/*
 *	思路：求字符串中最长回文串。dp题。时间复杂度O(n2)
 *  用一个数组dp记录子串s[i~j]是否是回文串O(n2)，然后遍历每个子串寻找最长回文串。
 *  状态定义:dp[i][j]表示s[i~j]是否是回文
 *  状态方程：dp[i][j] == true;		i==j
 *            dp[i][j] = s[i][j];	i+1 == j(包含两个字符的子串，只需判断这两个字符是否相等就可判断是否是回文)
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
