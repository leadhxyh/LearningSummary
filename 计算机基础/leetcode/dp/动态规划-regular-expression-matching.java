/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 *	
 */

/*
 *	思路：和wildcard-matching类似，不同的地方在于初始状态。
 *	如：s="", p="c*c*"。这里dp[0][2]=true, dp[0][4]=true;
 *	s="", p="aac*"。这里dp[0][4]=false;
 */

public class Solution {
    public boolean isMatch(String s, String p) {
    	int ls = s.length() + 1;
    	int lp = p.length() + 1;
    	//状态定义：dp[i][j]表示s[0~i-1]是否匹配p[0~j-1]
    	boolean[][] dp = new boolean[ls][lp];
        //初始状态：s="", p=""应该返回true
    	dp[0][0] = true;

        //这里和wildcard-matching题有区别
    	for (int i = 1; i < p.length(); i+=2) {
    		if (p.charAt(i) == '*')
    			dp[0][i+1] = true;
    		else
    			break;
    	}
        
        //其他初始状态如：s="", p="ab*"应该返回false
    	
        //递推关系式：
        //1.dp[i][j] = dp[i-1][j-1].   如果p[j-1]=='.' 或 s[i-1] == p[j-1]
        //2.dp[i][j] = dp[i-1][j] || dp[i][j-1].  dp[i-1][j]表示保留p中的*，可以匹配s中跟多字符,
        //dp[i][j-1]表示p中的*匹配空字符
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
