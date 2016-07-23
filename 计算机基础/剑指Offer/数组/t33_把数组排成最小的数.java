/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length == 0) {
            return "";
        }
		String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = "" + numbers[i];
        }
        Arrays.sort(str, new Comparator<String>() {
            
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
