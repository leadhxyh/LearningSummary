/*
 *
	世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？ 
	输入例子:
	1999 2299

	输出例子:
	7
 */

/*
 *	思路：先将m,n异或，然后检查结果中的1的个数。注意：>>>是零拓展无论操作数是正或负都在高位补0。>>是符号拓展
 */

public class Solution {
    /**
     * 获得两个整形二进制表达位数不同的数量
     * 
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
		int dif = m ^ n;
        int count = 0;
        while (dif != 0) {
            if ((dif & 0x01) == 1)
                count++;
            dif >>>= 1;
        }
        return count;
    }
}
