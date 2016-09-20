/*
 *	Implement wildcard pattern matching with support for'?'and'*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "*") �� true
isMatch("aa", "a*") �� true
isMatch("ab", "?*") �� true
isMatch("aab", "c*a*b") �� false
 */
/*
 *  ˼·���տ�ʼֱ�ӵݹ鳬ʱ������dpͨ��
 *	״̬���壺dp[i][j]��ʾs[0~i-1]�Ƿ�ƥ��p[0~j-1]
 *	���ƹ�ϵʽ��
 *	1.dp[i][j] = dp[i-1][j-1].   ���p[j-1]=='?' �� s[i-1] == p[j-1]
 *	2.dp[i][j] = dp[i-1][j] || dp[i][j-1].  dp[i-1][j]��ʾ����p�е�*������ƥ��s�и����ַ�,dp[i][j-1]��ʾp�е�*ƥ����ַ�
 *  ��ʼ״̬��s="", p=""Ӧ�÷���true, s="", p="*"Ӧ�÷���true, ������ʼ״̬�磺s="", p="ab*"Ӧ�÷���false
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        //ɾ���������*��ֻ����һ��*
    	p = removeduplicate(p);
        
    	int ls = s.length() + 1;
    	int lp = p.length() + 1;
    	//״̬���壺dp[i][j]��ʾs[0~i-1]�Ƿ�ƥ��p[0~j-1]
    	boolean[][] dp = new boolean[ls][lp];
        //��ʼ״̬��s="", p=""Ӧ�÷���true
    	dp[0][0] = true;

        //��ʼ״̬��s="", p="*"Ӧ�÷���true
    	if (p.length() > 0 && p.charAt(0) == '*')
    		dp[0][1] = true;
        
        //������ʼ״̬�磺s="", p="ab*"Ӧ�÷���false
    	
        //���ƹ�ϵʽ��
        //1.dp[i][j] = dp[i-1][j-1].   ���p[j-1]=='?' �� s[i-1] == p[j-1]
        //2.dp[i][j] = dp[i-1][j] || dp[i][j-1].  dp[i-1][j]��ʾ����p�е�*������ƥ��s�и����ַ�,
        //dp[i][j-1]��ʾp�е�*ƥ����ַ�
    	for (int i = 1; i < ls; i++) {
    		for (int j = 1; j < lp; j++) {
    			if (p.charAt(j-1) == '?' || (p.charAt(j-1) == s.charAt(i-1))) {
    				dp[i][j] = dp[i-1][j-1];
    			}
    			if (p.charAt(j-1) == '*') {
    				if (i == 1 && j == 1)
    					dp[i][j] = true;
    				else {
    					dp[i][j] = dp[i-1][j] || dp[i][j-1];
    				}
    			}
    		}
    	}
    	
    	
    	return dp[ls-1][lp-1];
    	
    }
    //ɾ�������ظ���*��ֻ����һ��*
    public String removeduplicate(String p) {
    	boolean last = false;
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < p.length(); i++) {
    		char c = p.charAt(i);
    		if (c != '*') {
    			sb.append(c);
    			last = false;
    		} else {
    			if (!last) {
    				sb.append(c);
    				last = true;
    			} else {
    				continue;
    			}
    		}
    	}
    	return sb.toString();
    }
}
