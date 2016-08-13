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
 * ˼·����̬�滮����isPal��ά���飬����s[i~j]�Ƿ����Ӵ������ж�s��벿��left�Ƿ��ǻ����ǵĻ����ݹ��Ұ벿�֡�
 */

public class Solution {    
public ArrayList<ArrayList<String>> partition(String s) {
	int l = s.length();
	//�ݹ����s[i-j]�Ƿ��ǻ��Ĵ�
	boolean[][] isPal = new boolean[l][l];
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < l; j++)
			isPal[i][j] = false;
	}
	for (int i = 0; i < l; i++) {
		for (int j = i; j >= 0; j--) {
			//s[i]==s[j] �� s[j+1, i-1]�ǻ���(abba)��i��j���벻����2(a��aa��aba)
			if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || isPal[j+1][i-1]))
				isPal[j][i] = true;
		}
	}
	
	ArrayList<String> onSolution = new ArrayList<>();
	ArrayList<ArrayList<String>> ans = new ArrayList<>();
	dfs(s, 0, isPal, onSolution, ans);
	return ans;
}

//�����������+��֦
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
