/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/*
 * 功能测试：
 * 边界测试：2,3,4,5;   1
 * 特殊值测试：null
 */
import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	if (array == null || array.length == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (array[index1] >= array[index2]) {		//数据为不递减时跳出
            if (index2 - index1 == 1 ) {
                mid = index2;
                break;
            }
            mid = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[index1] == array[mid]) {
                return minInOrder(array, index1, index2);
            }
            if (array[mid] >= array[index1]) {
                index1 = mid;
            } else if (array[mid] <= array[index2]) {
                index2 = mid;
            }
        }
        
        return array[mid];
    }
    
  	public int minInOrder(int[] array, int index1, int index2) {
    	int result = array[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if (array[i] < result){
                result = array[i];
            }
        }
        return result;
  	}
}
