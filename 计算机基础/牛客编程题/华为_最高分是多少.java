/*
��ʦ��֪����ĳĳͬѧ���У�������ߵ��Ƕ��٣�����������ģ����ʦ��ѯ�ʡ���Ȼ����ʦ��ʱ����Ҫ����ĳλͬѧ�ĳɼ�. 
��������:
�����������������ݡ�
ÿ�������һ��������������N��M��0 < N <= 30000,0 < M < 5000��,�ֱ����ѧ������Ŀ�Ͳ�������Ŀ��
ѧ��ID��Ŵ�1�ൽN��
�ڶ��а���N��������������N��ѧ���ĳ�ʼ�ɼ������е�i��������IDΪi��ѧ���ĳɼ�
��������M�У�ÿһ����һ���ַ�C��ֻȡ��Q����U������������������A,B,��CΪ'Q'��ʱ��, ��ʾ����һ��ѯ�ʲ�������ѯ��ID��A��B������A,B����ѧ�����У��ɼ���ߵ��Ƕ���
��CΪ��U����ʱ�򣬱�ʾ����һ�����²�����Ҫ���IDΪA��ѧ���ĳɼ�����ΪB��


�������:
����ÿһ��ѯ�ʲ�������һ�����������߳ɼ�.

��������:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

�������:
5
6
5
9
 */

/*
 *	˼·�������ƽ�
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
            //��ȡ�ɼ�
            for (int i = 1; i <= N; i++) {
                score[i] = in.nextInt();
            }
            
			String c = null;
            //ִ�в���
            for (int i = 0; i < M; i++) {
                c = in.next();
            	A = in.nextInt();
                B = in.nextInt();
                if (c.equals("Q")) {
                    //��ȡ��߳ɼ�
                    int start = A <= B ? A : B;
                    int end = A > B ? A : B;
                    int max = score[start];
                    for (int j = start + 1; j <= end; j++) {
                        if (score[j] > max)
                            max = score[j];
                    }
                    System.out.println(max);
                } else if (c.equals("U")) {
                    //�޸ĳɼ�
                    score[A] = B;
                }
            }
        }
    }
}
