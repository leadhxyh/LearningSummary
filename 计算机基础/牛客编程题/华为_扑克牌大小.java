/*
 *	�˿�����Ϸ���Ӧ�ö��Ƚ���Ϥ�ˣ�һ������54����ɣ���3~A��2��4�ţ�С��1�ţ�����1�š������С�����������ַ����ַ�����ʾ�����У�Сдjoker��ʾС������дJOKER��ʾ������:) 
3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER 
���������ƣ�������֮���á�-�����ӣ�ÿ���Ƶ�ÿ�����Կո�ָ�����-������û�пո��磺4 4 4 4-joker JOKER
��Ƚ������ƴ�С������ϴ���ƣ���������ڱȽϹ�ϵ�����ERROR

��������
��1������ÿ���ƿ����Ǹ��ӣ����ӣ�˳�ӣ�����5�ţ���������ը�����ĸ����Ͷ����е�һ�֣���������������������뱣֤�����ƶ��ǺϷ��ģ�˳���Ѿ���С�������У�
��2������ը���Ͷ������Ժ������ƱȽ�֮�⣬�������͵���ֻ�ܸ���ͬ���͵Ĵ��ڱȽϹ�ϵ���磬���Ӹ����ӱȽϣ������������Ƚϣ��������ǲ���������磺�����Ӳ�ֳɸ��ӣ�
��3����С��������ƽʱ�˽�ĳ���������ͬ�����ӣ����ӣ������Ƚ������С��˳�ӱȽ���С�ƴ�С��ը������ǰ�����е��ƣ�ը��֮��Ƚ������С�������������ƣ�
��4������������Ʋ��������ȵ������

����ʾ��
��1������ը���Ͷ���֮�⣬��������ͬ���ͱȽϡ�
��2�������Ѿ���֤�Ϸ��ԣ����ü�������Ƿ��ǺϷ����ơ�
��3�������˳���Ѿ�������С����������˲�����������.

��������:
���������ƣ�������֮���á�-�����ӣ�ÿ���Ƶ�ÿ�����Կո�ָ�����-������û�пո���4 4 4 4-joker JOKER��


�������:
����������нϴ�����֣��������ӷ����˿���˳�򲻱䣬���Կո��������������ڱȽϹ�ϵ�����ERROR��

��������:
4 4 4 4-joker JOKER

�������:
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

//��������
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

