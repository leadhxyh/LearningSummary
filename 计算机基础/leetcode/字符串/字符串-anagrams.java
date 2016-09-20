/*
 *	Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
 */

import java.util.*;
public class Solution {

	public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for (String s : strs) {
        	char[] chars = s.toCharArray();
        	Arrays.sort(chars, 0, s.length());
        	String sorted = new String(chars);
        	
        	ArrayList<String> l = map.get(sorted);
        	if (l != null) {
        		l.add(s);
        	} else {
        		ArrayList<String> newList = new ArrayList<>();
        		newList.add(s);
				map.put(sorted, newList);
			}	
        }
        
        Collection<ArrayList<String>> valus = map.values();
        for (ArrayList<String> l : valus) {
        	if (l.size() != 1) {
            	ret.addAll(l);
        	}
        }
        
        return ret;
    }
}
