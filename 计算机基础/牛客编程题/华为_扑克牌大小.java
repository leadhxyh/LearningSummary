/*
 *	扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:) 
3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER 
输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR

基本规则：
（1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
（2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
（3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
（4）输入的两手牌不会出现相等的情况。

答案提示：
（1）除了炸弹和对王之外，其他必须同类型比较。
（2）输入已经保证合法性，不用检查输入是否是合法的牌。
（3）输入的顺子已经经过从小到大排序，因此不用再排序了.

输入描述:
输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如4 4 4 4-joker JOKER。


输出描述:
输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。

输入例子:
4 4 4 4-joker JOKER

输出例子:
joker JOKER
 */

import java.util.*;

public class Main{
	
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int TRIBLE = 3;
    public static final int SHUNZI = 5;
    public static final int ZHA = 4;
    public static final int JOKER = 6;
    
    public static void main(String[] args) {
 
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
        	String ret;
            String s = cin.nextLine();
            String[] ss = s.split("-");
            String s1 = ss[0];
            String s2 = ss[1];
            int num1 = s1.split("\\s").length;
            int num2 = s2.split("\\s").length;
            int type1 = getType(s1);
            int type2 = getType(s2);
            if (num1 == num2) {
                if (type1 == JOKER || type2 == JOKER) {
                    ret =  type1 == JOKER ? s1 : s2;
                } else {
                   char c1 = s1.charAt(0);
                   char c2 = s2.charAt(0);
                   ret = getPriority(c1) > getPriority(c2) ? s1 : s2;
                }
            } else {
                if (type1 == JOKER || type2 == JOKER) {
                    ret =  type1 == JOKER ? s1 : s2;
                } else {
                    if (type1 == ZHA || type2 == ZHA) {
                        ret =  type1 == ZHA ? s1 : s2;
                    } else {
                        ret =  "ERROR";
                    }
                }
            }
            System.out.println(ret);
        }
        

    }
    
    
static int getPriority(char c) {
    int p = 3;
    if (c == '2') {
        p = 15;
    } else if (c == 'J') {
        p = 11;
    } else if (c == 'Q') {
        p = 12;
    } else if (c == 'K') {
        p = 13;
    } else if (c == 'A') {
        p = 14;
    } else if (c == '1') {
        p = 10;
    } else {
        p = c - '0';
    }
    return p;
}

//返回类型
private static int getType(String s) {
    String[] ss = s.split("\\s");
    switch (ss.length) {
        case 1:
        	return SINGLE;
        case 2:
        	if (ss[0].length() == 5) {
                return JOKER;
            } else {
                return DOUBLE;
            }
        case 3:
        	return TRIBLE;
        case 4:
        	return ZHA;
        case 5:
        	return SHUNZI;
        
    }
	return 0;
}
}

