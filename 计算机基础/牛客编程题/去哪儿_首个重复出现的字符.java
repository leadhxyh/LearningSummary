/*
 *
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
测试样例：
"qywyer23tdd",11
返回：y
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
