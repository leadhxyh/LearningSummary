/*
 *	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

/*
 *	思路：动态规划。sum[i][j] = min(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j];
 */




public class Solution {
   public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        int[][] pathSum = new int[len][len];
        pathSum[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            ArrayList<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                pathSum[i][j] = min(pathSum, i - 1, j - 1, j) + triangle.get(i).get(j);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = pathSum[len - 1][i] < min ? pathSum[len - 1][i] : min;
        }
        return min;
    }
    //计算row行left, mid两个位置的最小值
    public int min(int[][] sum, int row, int left, int mid) {
        int min = Integer.MAX_VALUE;
        if (left >= 0 && left <= row && sum[row][left] < min){
            min = sum[row][left];
        }
        if (mid >= 0 && mid <= row && sum[row][mid] < min){
            min = sum[row][mid];
        }
 
        return min;
    }
}
