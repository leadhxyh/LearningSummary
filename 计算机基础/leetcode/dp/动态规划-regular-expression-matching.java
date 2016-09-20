/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "a*") �� true
isMatch("aa", ".*") �� true
isMatch("ab", ".*") �� true
isMatch("aab", "c*a*b") �� true
 *	
 */

/*
 *	˼·����wildcard-matching���ƣ���ͬ�ĵط����ڳ�ʼ״̬��
 *	�磺s="", p="c*c*"������dp[0][2]=true, dp[0][4]=true;
 *	s="", p="aac*"������dp[0][4]=false;
 */

public class Solution {
    public boolean isMatch(String s, String p) {
    	int ls = s.length() + 1;
    	int lp = p.length() + 1;
    	//״̬���壺dp[i][j]��ʾs[0~i-1]�Ƿ�ƥ��p[0~j-1]
    	boolean[][] dp = new boolean[ls][lp];
        //��ʼ״̬��s="", p=""Ӧ�÷���true
    	dp[0][0] = true;

        //�����wildcard-matching��������
    	for (int i = 1; i < p.length(); i+=2) {
    		if (p.charAt(i) == '*')
    			dp[0][i+1] = true;
    		else
    			break;
    	}
        
        //������ʼ״̬�磺s="", p="ab*"Ӧ�÷���false
    	
        //���ƹ�ϵʽ��
        //1.dp[i][j] = dp[i-1][j-1].   ���p[j-1]=='.' �� s[i-1] == p[j-1]
        //2.dp[i][j] = dp[i-1][j] || dp[i][j-1].  dp[i-1][j]��ʾ����p�е�*������ƥ��s�и����ַ�,
        //dp[i][j-1]��ʾp�е�*ƥ����ַ�
    	for (int i = 1; i < ls; i++) {
    		for (int j = 1; j < lp; j++) {
    			if (p.charAt(j-1) == '.' || (p.charAt(j-1) == s.charAt(i-1))) {
    				dp[i][j] = dp[i-1][j-1];
    			}
    			if (p.charAt(j-1) == '*') {
    				if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
    					dp[i][j] = dp[i-1][j-2] || dp[i][j-2] || dp[i-1][j];
    				} else {
    					dp[i][j]  = dp[i][j-2];
    				}
    			}
    		}
    	}
    	
    	
    	return dp[ls-1][lp-1];
    	
    }
   
}
