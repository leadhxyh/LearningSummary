/*
 *	A message containing letters fromA-Zis being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
The number of ways decoding"12"is 2.
 */

/*
 *	˼·��dp�⡣
 *	״̬���壺dp[i]��ʾs[0 ~ i-1]�Ӵ��ܽ��������
 *	���Ʒ��̣����1 <= s[i-1] <= 9����dp[i] += dp[i-1]��  ���10 <= s[i-2 ~ i-1] <= 26, ��dp[i] += dp[i - 2].
 *	��ʼ״̬��dp[0] = 1, dp[1] = 1;
 *	ע�⣺��s��0��ͷʱ������0
 */

public class Solution {
	public int numDecodings(String s) {
     	if (s.length() == 0 || s.startsWith("0"))
            return 0;
		int len = s.length() + 1;
        int[] dp = new int[len];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i < len; i++) {
        	int t = Integer.valueOf(s.substring(i - 2, i));
        	if (10 <= t && t <= 26) {
        		dp[i] += dp[i - 2];
        	} 
        	//ע��0������Ҫ����Դ�
        	int tmp = Integer.valueOf(s.substring(i - 1, i));
        	if (1 <= tmp && tmp <= 9) {
        		dp[i] += dp[i - 1];
        	}
        }
        return dp[len - 1];
    }
}
