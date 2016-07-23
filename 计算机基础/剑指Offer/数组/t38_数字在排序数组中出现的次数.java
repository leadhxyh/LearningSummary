/* 
 * ͳ��һ�����������������г��ֵĴ�����
 */
/*
 * ���ܲ��ԣ�[1, 2, 3, 3, 3, 3, 4, 5], k=3
 * �߽���ԣ�[1], k=1, k=0
 * ����ֵ��null
 */

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if (array == null || array.length == 0) {
           return 0;
       }
        
       int firstIndex  = getFirstIndex(array, k);
       int lastIndex = getLastIndex(array, k);
       if (firstIndex != -1 && lastIndex != -1) {
           return lastIndex - firstIndex + 1; 
       }
       return 0;
    }
    
    //��ȡ��һ��k���±꣬�������ڷ���-1
    public int getFirstIndex(int[] array, int k) {
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (index1 <= index2) {
            mid = (index1 + index2) / 2;
            if (array[mid] == k) {
                if ((mid > 0 && array[mid-1] != k) || mid == 0) {
                    return mid;
                } else {
                    index2 = mid - 1;
                }
            } else if (array[mid] < k) {
                index1 = mid + 1;
            } else {
                index2 = mid - 1;
            }
        }
        
        return -1;
    }
    
    public int getLastIndex(int[] array, int k) {
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (index1 <= index2) {
            mid = (index1 + index2) / 2;
            
            if (array[mid] == k) {
                if ((mid <= array.length - 2 && array[mid+1] != k)
                    || mid == array.length - 1) {
                    return mid;
                } else {
                    index1 = mid + 1;
                }
            } else if (array[mid] < k) {
                index1 = mid + 1;
            } else {
                index2 = mid - 1;
            }
        }
        return -1;
    }
}
