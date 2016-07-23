/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */

public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        
        return inversePairsCore(array, 0, array.length - 1);
        
    }
    
	/*
	 * 有两个职责：1、返回该部分的逆序对数，2.对该部分数组进行排序
	 */
    public int inversePairsCore(int[] array, int index1, int index2) {
		//终止条件
        if (index1 == index2) {
            return 0;
        }
        int mid = (index1 + index2) / 2;

		//递归左半部分
        int leftCount = inversePairsCore(array, index1, mid);
		//递归右半部分
        int rightCount = inversePairsCore(array, mid + 1, index2);
        int[] tem = new int[index2 - index1 + 1];
        int leftP = mid;
        int rightP = index2;
        int newP = tem.length - 1;
		//排序过程中记录逆序对数
        int currentCount = 0;
        while (leftP >= index1 && rightP > mid) {
            if (array[leftP] > array[rightP]) {
                tem[newP--] = array[leftP--];
                currentCount += (rightP - mid);
            } else {
                tem[newP--] = array[rightP--];
            }
        }
        while (leftP >= index1) {
            tem[newP--] = array[leftP--];
        }
        while (rightP > mid) {
            tem[newP--] = array[rightP--];
        }
        
        for (int i = 0; i < tem.length; i++) {
            array[index1 + i] = tem[i];
        }
        return leftCount + rightCount + currentCount;
    }
}
