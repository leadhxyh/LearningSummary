/**
 *	如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 */

/**
 *	思路：用一个最大堆保存小于中位数的数，最小堆保存大于中位数的数，每次插入
 *	维持两个堆数目不超过1。插入：O(lg(n)), 查找：O(1)
 */

public class Solution {
	int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    PriorityQueue<Integer> maxHeap = new PriorityQueue(15, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
});
    public void Insert(Integer num) {
    	if ((count & 0x01) == 0) {		//总数为偶数,加入最小堆
            //若当前数小于最大堆的元素，则不能直接插入最小堆。应将其插入最大堆进行过滤
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
      		int filteredMinNum = minHeap.poll();
        	//2.筛选后的【小根堆中的最小元素】进入小根堆
			maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if ((count & 0x01) == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
