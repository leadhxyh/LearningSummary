/*
 *	There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

/*
 * 思路：需要注意，不易想到。见注释。时间复杂度O(n)
 */


public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1)
            return 1;
        int[] candys = new int[n];
        //首先给每个孩子一个糖 
        for (int i = 0; i < n; i++)
            candys[i] = 1;
        //从左向右扫描，第i个孩子权值大于第i-1个孩子，那么给第i个孩子i-1个孩子糖树+1个糖
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candys[i] = candys[i - 1] + 1;
        }
        //从右向左扫描，如果第i个孩子权值大于第i+1个孩子
        //且第i个孩子的糖果小于等于第i+1个孩子的糖果，那么给第i个孩子candys[i+1]+1个糖
        for (int i = n - 2; i >= 0; i--) {
            if ((ratings[i] > ratings[i + 1]) && (candys[i] <= candys[i + 1]))
                candys[i] = candys[i + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += candys[i];
        return sum;
    }
}
