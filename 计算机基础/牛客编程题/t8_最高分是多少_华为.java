/*
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩. 
输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。


输出描述:
对于每一次询问操作，在一行里面输出最高成绩.

输入例子:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子:
5
6
5
9
 */

/*
 *	思路：暴力破解
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        int M = 0;
        int A = 0;
        int B = 0;

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            M = in.nextInt();
            int[] score = new int[N + 1];
            //读取成绩
            for (int i = 1; i <= N; i++) {
                score[i] = in.nextInt();
            }
            
			String c = null;
            //执行操作
            for (int i = 0; i < M; i++) {
                c = in.next();
            	A = in.nextInt();
                B = in.nextInt();
                if (c.equals("Q")) {
                    //获取最高成绩
                    int start = A <= B ? A : B;
                    int end = A > B ? A : B;
                    int max = score[start];
                    for (int j = start + 1; j <= end; j++) {
                        if (score[j] > max)
                            max = score[j];
                    }
                    System.out.println(max);
                } else if (c.equals("U")) {
                    //修改成绩
                    score[A] = B;
                }
            }
        }
    }
}
