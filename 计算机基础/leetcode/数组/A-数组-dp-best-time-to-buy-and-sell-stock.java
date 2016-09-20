/*
 *	Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        
        int len = prices.length;
        int[] dif = new int[len - 1];
        //计算相邻两天的价格差，将问题转换为求数组中子串最大和
        for (int i = 0; i < dif.length; i++) {
            dif[i] = prices[i+1] - prices[i];
        }
        
        //f[i]表示以i结尾的子串的最大和
        int[] f = new int[dif.length];
        f[0] = dif[0];
        int max = f[0];
        for (int i = 1; i < dif.length; i++) {
            if (f[i-1] < 0) {
                f[i] = dif[i];
            } else {
                f[i] = dif[i] + f[i-1];
            }
            if (f[i] > max)
                max = f[i];
        }
        
        return max < 0 ? 0 : max;

    }
}
