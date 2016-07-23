/**
 *	��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ
 */

/**
 *	˼·����һ�����ѱ���С����λ����������С�ѱ��������λ��������ÿ�β���
 *	ά����������Ŀ������1�����룺O(lg(n)), ���ң�O(1)
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
    	if ((count & 0x01) == 0) {		//����Ϊż��,������С��
            //����ǰ��С�����ѵ�Ԫ�أ�����ֱ�Ӳ�����С�ѡ�Ӧ����������ѽ��й���
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
      		int filteredMinNum = minHeap.poll();
        	//2.ɸѡ��ġ�С�����е���СԪ�ء�����С����
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
