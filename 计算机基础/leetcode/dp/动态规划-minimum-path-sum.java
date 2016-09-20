/*
 *Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
 */



public class Solution {
    public int minPathSum(int[][] grid) {
        
        int rows = grid.length + 1;
        int cols = grid[0].length + 1;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
     	   dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i < rows; i++) {
     	   for (int j = 1; j < cols; j++) {
     		   if (i == 1 && j == 1) {
     			   dp[i][j] = grid[i-1][j-1];
     		   } else {
     			  dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
			}
     		   
     	   }
        }
        return dp[rows - 1][cols - 1];
     }
}
