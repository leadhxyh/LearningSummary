/*
 *	Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].
 */

/*
 *	思路：将字符串切割为两部分左边s1和右边s2，如果s1包含在字典中，则递归计算s2切割生成的字符串集合，并将s1和s2返回的结果并和。
 *	s2可能无法切割，我们让其返回一个空的ArrayList。
 *	s为空串是我们规定返回包含一个“”的ArrayList.
 *	仅仅递归会超时，我们用一个map记录字符串对应的结果。
 */

import java.util.*;
public class Solution {
 public  ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
            
    }
	
	public  ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return (ArrayList<String>) map.get(s);
        
        ArrayList<String> lists = new ArrayList();
        if (s.equals("")) 
            lists.add("");
        else {
        	int len = s.length();
        	for (int i = 1; i <= len; i++) {
        		String sub = s.substring(0, i);
        		if (dict.contains(sub)) {
        			ArrayList t = dfs(s.substring(i, len), dict, map);
        			if (t.size() == 0) {
        				continue;
        			} else {
        				for (int j = 0; j < t.size(); j++) {
							StringBuilder sb = new StringBuilder();
        					sb.append(sub).append(" ").append(t.get(j));
        					lists.add(sb.toString().trim());

        				}
        			}
        		}
        	}
        }
        map.put(s, lists);
        return lists;
    }
}
