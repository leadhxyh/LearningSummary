/*
 *	Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A =[1,1,1,2,2,3],
Your function should return length =5, and A is now[1,1,2,2,3].
 */

public class Solution {
     public int removeDuplicates(int[] A) {
        
        int len = A.length;
        if (len < 3)
            return len;
        
        for (int i = 0; i < len; i++) {
            //超过两次重复
            if (i + 2 < len && A[i] == A[i+2]) {
                int next = i + 3;
                //next指向结尾或下一个与当前不相等的元素
                while (next != len && A[next] == A[i]) {
                    next++;
                }
                //将要删除的元素设置标记
                for (int j = i + 2; j < next; j++) {
                    A[j] = Integer.MAX_VALUE;
                }
				i = (next - 1);
            } 
        }
        
        //从后向前填充，跳过前面标记过的元素
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != Integer.MAX_VALUE) {
                A[j++] = A[i];
            }
        }
        
        return j;
        
    }
}
