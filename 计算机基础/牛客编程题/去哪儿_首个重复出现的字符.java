/*
 *
 * ����һ���ַ����������һ����Ч�㷨���ҵ���һ���ظ����ֵ��ַ���
����һ���ַ���(��һ��ȫΪ��ĸ)A�����ĳ���n���뷵�ص�һ���ظ����ֵ��ַ�����֤�ַ��������ظ��ַ����ַ����ĳ���С�ڵ���500��
����������
"qywyer23tdd",11
���أ�y
*/

import java.util.*;

public class FirstRepeat {
    public char findFirstRepeat(String A, int n) {
        // write code here
        char target = 'a';
        Set<Character> set = new HashSet();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (set.contains(c)) {
                target = c;
                break;
            } else {
                set.add(c);
            }
        }
        return target;
    }
}
