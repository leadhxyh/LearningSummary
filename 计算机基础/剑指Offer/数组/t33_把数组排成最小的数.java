/*
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
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
