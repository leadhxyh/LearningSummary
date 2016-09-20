/*
 *	Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s ="aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */

/*
 * 思路：动态规划计算isPal二维数组，计算s[i~j]是否是子串。先判断s左半部分left是否是回文是的话，递归右半部分。
 */

public class Solution {    
public ArrayList<ArrayList<String>> partition(String s) {
	int l = s.length();
	//递归计算s[i-j]是否是回文串
	boolean[][] isPal = new boolean[l][l];
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < l; j++)
			isPal[i][j] = false;
	}
	for (int i = 0; i < l; i++) {
		for (int j = i; j >= 0; j--) {
			//s[i]==s[j] 且 s[j+1, i-1]是回文(abba)或i和j距离不大于2(a或aa或aba)
			if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || isPal[j+1][i-1]))
				isPal[j][i] = true;
		}
	}
	
	ArrayList<String> onSolution = new ArrayList<>();
	ArrayList<ArrayList<String>> ans = new ArrayList<>();
	dfs(s, 0, isPal, onSolution, ans);
	return ans;
}

//深度优先搜索+剪枝
public void dfs(String s, int start, boolean[][] isPal, ArrayList<String> onSolution, ArrayList<ArrayList<String>> ans) {
	if (start == s.length()) {
		ArrayList<String> copy = (ArrayList<String>) onSolution.clone();
		ans.add(copy);
		return;
	}
	for (int i = start; i < s.length(); i++) {
		if (isPal[start][i]) {
			onSolution.add(s.substring(start, i + 1));
			dfs(s, i + 1, isPal, onSolution, ans);
			onSolution.remove(onSolution.size() - 1);
		}
	}
}
}
