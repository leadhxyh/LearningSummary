/*
 *	Given an absolute path for a file (Unix-style), simplify it.
For example,
path ="/home/", =>"/home"
path ="/a/./b/../../c/", =>"/c"
click to show corner cases.
Corner Cases:

Did you consider the case where path ="/../"?
In this case, you should return"/".
Another corner case is the path might contain multiple slashes'/'together, such as"/home//foo/".
In this case, you should ignore redundant slashes and return"/home/foo".
 */

import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
    	String[] str = path.split("/");
    	LinkedList<String> queue = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	//���ܵ����:
        //1."." �� "" : ����
        //2."a" : ����linkedList
        //3.".." : ���queue�ǿ��򵯳�����β����Ԫ�أ���Ӧ�ڷ�����һ��Ŀ¼z
    	for (String s : str) {
    		if (s.equals(".") || s.equals("")) {
    			continue;
    		}
    		if (s.equals("..")) {
    			if (!queue.isEmpty()) {
        			queue.pollLast();    				
    			} else {
    				continue;
    			}
    		} else {
				queue.addLast(s);
			}
    	}
        
        if (queue.isEmpty()) {
            return "/";
        }
    	while (!queue.isEmpty()) {
			sb.append("/" + queue.pollFirst());
		}
    	return sb.toString();
    }
}
