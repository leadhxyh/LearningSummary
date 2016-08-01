/*
���֮�£����ܷɡ������й�����ţ�У����ν����������ꡱ�� ����һ���ع���ʷ�Ļ��ᣬ��֪һ֧��Ʊ����n��ļ۸����ƣ��Գ���Ϊn�����������ʾ�������е�i��Ԫ�أ�prices[i]������ù�Ʊ��i��Ĺɼۡ� ������һ��ʼû�й�Ʊ������������������1�ɶ�������1�ɵĻ��ᣬ��������ǰһ��Ҫ�ȱ�֤����û�й�Ʊ�������ν��׻��ᶼ����������Ϊ0�� ����㷨���������ܻ�õ�������档 ������ֵ��Χ��2<=n<=100,0<=prices[i]<=100 
��������:
3,8,5,1,7,8

�������:
12
*/

/*
 *	˼·��preProfit[i]��ʾ����i���õ�������棬postProfit[i]��ʾ�ӵ�i�쿪ʼ�����һ���õ����档�������Ϊmax{preProfit[i] + postProfit[i]}
 *	����preProfit[i]����̬�滮��curMIn�����i��ǰ��ͼۣ�preProfit[i] = max{prices[i] - curMin, priProfit[i-1]}.����postProfit[i]����
 */

public class Solution {
    /**
     * �������ܻ�õ��������
     * 
     * @param prices Prices[i]����i��Ĺɼ�
     * @return ����
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
