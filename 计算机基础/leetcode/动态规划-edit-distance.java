/*
 *	Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 */

/*
 * 思路：
 * 状态定义：dp[i][j]:word1[0~i-1]转变为word2[0~j-1]的步骤数
 * 状态转移方程：dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] +　f(word[i-1], word2[j-1])),   f(x, y):x等于y为0， 否则返回1
 * 初始状态
 */

public class Solution {
    public int minDistance(String word1, String word2) {
       int l1 = word1.length() + 1;
       int l2 = word2.length() + 1;
       
       int[][] dp = new int[l1][l2];
       for (int j = 0; j < l2; j++) {
    	   dp[0][j] = j;
       }
       for (int i = 0; i < l1; i++) {
    	   dp[i][0] = i;
       }
       
       for (int i = 1; i < l1; i++) {
    	   for (int j = 1; j < l2; j++) {
    		   int min = dp[i - 1][j - 1];
			   if (word1.charAt(i - 1) != word2.charAt(j - 1))
				   min++;
			   min = Math.min(min, dp[i][j - 1] + 1);
			   min = Math.min(min, dp[i - 1][j] + 1);
    		   dp[i][j] = min;
    	   }
       }
       return dp[l1 - 1][l2 - 1]; 
    }
}
