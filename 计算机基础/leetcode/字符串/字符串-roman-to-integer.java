/*
 *	Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
 */

/*
 * 基本字符	对应的数字
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
正常使用时、连写的数字重复不得超过三次；
在一个数的上面画一条横线、表示这个数扩大 1000 倍。
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
