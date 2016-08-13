/*
 *	There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

/*
 * ˼·����Ҫע�⣬�����뵽����ע�͡�ʱ�临�Ӷ�O(n)
 */


public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1)
            return 1;
        int[] candys = new int[n];
        //���ȸ�ÿ������һ���� 
        for (int i = 0; i < n; i++)
            candys[i] = 1;
        //��������ɨ�裬��i������Ȩֵ���ڵ�i-1�����ӣ���ô����i������i-1����������+1����
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candys[i] = candys[i - 1] + 1;
        }
        //��������ɨ�裬�����i������Ȩֵ���ڵ�i+1������
        //�ҵ�i�����ӵ��ǹ�С�ڵ��ڵ�i+1�����ӵ��ǹ�����ô����i������candys[i+1]+1����
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
