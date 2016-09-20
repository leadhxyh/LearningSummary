/*
 *	Given two binary strings, return their sum (also a binary string).
For example,
a ="11"
b ="1"
Return"100".
 */

/*
 *	首先不能用转换为int或long来处理，防止溢出。只能模拟加法操作
 */
public class Solution {
    public String addBinary(String a, String b) {
    	int la = a.length();
    	int lb = b.length();
    	char[] sum = new char[la > lb ? la : lb];
    	int i = la - 1, j = lb - 1, k = sum.length - 1;
		//模拟相加操作
    	for (; i >= 0 && j >= 0; i--, j--, k--) {
    		sum[k] = (char) ((a.charAt(i) - '0') + (b.charAt(j) - '0') + '0');
    	}
    	while (i >= 0) {
    		sum[k--] = a.charAt(i--);
    	}
    	while (j >= 0) {
    		sum[k--] = b.charAt(j--);
    	}
    	
    	//处理进位
    	for (int l = sum.length - 1; l > 0; l--) {
    		int x = (sum[l] - '0') % 2;
    		int carry = (sum[l] - '0') / 2;
    		sum[l] = (char) ('0' + x);
    		sum[l - 1] = (char) (sum[l - 1] + carry);
    	}
    	
		//处理进位后溢出的情况
    	if (sum[0] == '2' || sum[0] == '3') {
    		char[] newSum = new char[sum.length + 1];
    		System.arraycopy(sum, 1, newSum, 2, sum.length - 1);
    		newSum[1] = (char) ((sum[0] - '0') % 2 + '0');
    		newSum[0] = (char) ((sum[0] - '0') / 2 + '0');
    		String string = new String(newSum);
    		return string;
    	}
    	
    	return new String(sum);
    	
    }
}
