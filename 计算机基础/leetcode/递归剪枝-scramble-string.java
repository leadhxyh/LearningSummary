/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 ="great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node"gr"and swap its two children, it produces a scrambled string"rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that"rgeat"is a scrambled string of"great".
Similarly, if we continue to swap the children of nodes"eat"and"at", it produces a scrambled string"rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that"rgtae"is a scrambled string of"great".
Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *	
 */

/*
 *	˼·���Ӽ������ʼ��
 *	1.�����ַ�����ֻ��һ���ַ�ʱֻ��Ƚ��Ƿ����
 *	2.�ַ���������һʱ�����жϳ����Ƿ���ȣ����ж��Ƿ�����ͬ���ַ���ɣ�������ֱ�ӷ���false
 *	3.�ָ��ַ����������������һ���ǲ�������һ�������ҽ���
 */

public class Solution {
	public boolean isScramble(String s1, String s2) {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	if (len1 != len2)
    		return false;
    	if (len1 == 1)
    		return s1.equals(s2);
        //��֦:������󲻲������ض�����������
    	char[] chars1 = new char[len1];
    	s1.getChars(0, len1, chars1, 0);
    	Arrays.sort(chars1);
    	char[] chars2 = new char[len1];
    	s2.getChars(0, len2, chars2, 0);
    	Arrays.sort(chars2);
    	if (!(new String(chars1).equals(new String(chars2))))
    		return false;
        
    	for (int i = 1; i < len1; i++) {
    		String s1left = s1.substring(0, i);
    		String s1right = s1.substring(i, len1);
    		String s2left = s2.substring(0, i);
    		String s2right = s2.substring(i, len1);
    		
    		//�ڵ�ǰ�ָû�н���
    		if (isScramble(s1left, s2left) && isScramble(s1right, s2right))
    			return true;
    		//��ǰ�ָ���ҽ���
   			s2right = s2.substring(len1 - i, len1);
    		s2left = s2.substring(0, len1 - i);
    		
    		if (isScramble(s1left, s2right) && isScramble(s1right, s2left))
    			return true;
    	}
		return false;
    }
}
