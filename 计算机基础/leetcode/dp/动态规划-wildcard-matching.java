/*
 *	Implement wildcard pattern matching with support for'?'and'*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
/*
 *  思路：刚开始直接递归超时，改用dp通过
 *	状态定义：dp[i][j]表示s[0~i-1]是否匹配p[0~j-1]
 *	递推关系式：
 *	1.dp[i][j] = dp[i-1][j-1].   如果p[j-1]=='?' 或 s[i-1] == p[j-1]
 *	2.dp[i][j] = dp[i-1][j] || dp[i][j-1].  dp[i-1][j]表示保留p中的*，可以匹配s中跟多字符,dp[i][j-1]表示p中的*匹配空字符
 *  初始状态：s="", p=""应该返回true, s="", p="*"应该返回true, 其他初始状态如：s="", p="ab*"应该返回false
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        //删除连续多个*，只保留一个*
    	p = removeduplicate(p);
        
    	int ls = s.length() + 1;
    	int lp = p.length() + 1;
    	//状态定义：dp[i][j]表示s[0~i-1]是否匹配p[0~j-1]
    	boolean[][] dp = new boolean[ls][lp];
        //初始状态：s="", p=""应该返回true
    	dp[0][0] = true;

        //初始状态：s="", p="*"应该返回true
    	if (p.length() > 0 && p.charAt(0) == '*')
    		dp[0][1] = true;
        
        //其他初始状态如：s="", p="ab*"应该返回false
    	
        //递推关系式：
        //1.dp[i][j] = dp[i-1][j-1].   如果p[j-1]=='?' 或 s[i-1] == p[j-1]
        //2.dp[i][j] = dp[i-1][j] || dp[i][j-1].  dp[i-1][j]表示保留p中的*，可以匹配s中跟多字符,
        //dp[i][j-1]表示p中的*匹配空字符
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
    //删除连续重复的*，只保留一个*
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
