/*
 *	Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
 */

/*
 * �����ַ�	��Ӧ������
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
��ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
����ʹ��ʱ����д�������ظ����ó������Σ�
��һ���������滭һ�����ߡ���ʾ��������� 1000 ����
 */

import java.util.*;
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int preValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	int curValue = map.get(s.charAt(i));
        	if (curValue < preValue)
        		ans -= curValue;
        	else 
        		ans += curValue;
        	preValue = curValue;
        	
        }
        return ans;
        
    }
}
