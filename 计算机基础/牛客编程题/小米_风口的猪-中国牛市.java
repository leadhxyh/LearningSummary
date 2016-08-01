/*
风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100 
输入例子:
3,8,5,1,7,8

输出例子:
12
*/

/*
 *	思路：preProfit[i]表示到第i天获得的最大收益，postProfit[i]表示从第i天开始到最后一天获得的收益。最大收益为max{preProfit[i] + postProfit[i]}
 *	计算preProfit[i]：动态规划，curMIn保存第i天前最低价，preProfit[i] = max{prices[i] - curMin, priProfit[i-1]}.计算postProfit[i]类似
 */

public class Solution {
    /**
     * 计算你能获得的最大收益
     * 
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
		if (prices.length < 2) return 0;
        
        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        
        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        
        return  maxProfit;
    
    }
}
