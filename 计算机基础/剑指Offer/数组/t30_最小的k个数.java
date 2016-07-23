/**
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,
 */

/**
 * ˼·��ʹ�ô���Ѱѱ�����С��K����������Ԫ�ظ���С��kֱ�Ӽ���ѣ���������ǰԪ�رȶѶ�Ԫ��С��ɾ���Ѷ�Ԫ�أ������Ԫ�ء������ȶ���ģ������.
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
