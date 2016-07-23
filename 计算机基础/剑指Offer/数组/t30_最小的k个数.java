/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */

/**
 * 思路：使用大根堆把保存最小的K个数，若堆元素个数小于k直接加入堆，否则若当前元素比堆顶元素小则删除堆顶元素，加入该元素。用优先队列模拟大根堆.
 */

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null) {
            return null;
        } 
        if (k <= 0 || input.length < k) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
			}
		});
        
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else {
                if (input[i] < queue.peek()) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        while (queue.size() > 0) {
            list.add(queue.poll());
        }
        
        Collections.sort(list);
        return list;
        
    }
}
