/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

/**
 * 思路：个数超过一半数必定是中位数，首先计算中位数，然后判断是否超过半数。
 */

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //计算中位数
        int mid = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index < mid) {
                start = index + 1;
                index = partition(array, start, end);
            } else {
                end = index - 1;
                index = partition(array, start, end);
            }
        }
        int result = array[index];
        
        //检查是否超过半数
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                time++;
            }
        }
        if (time * 2 <= array.length) {
            return 0;
        } else {
            return result;
        }
    }
    
    public int partition(int[] array, int index1, int index2) {
        int i = index1 - 1;
        for (int j = index1; j < index2 - 1; j++) {
            if (array[j] < array[index2]) {
                i++;
                int tem = array[i];
                array[i] = array[j];
                array[j] = tem;
            }
           
        }
        int t = array[i + 1];
        array[i + 1] = array[index2];
        array[index2] = t;
        return i + 1;
    }
}
