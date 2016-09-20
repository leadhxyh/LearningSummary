/*
 *	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
Your algorithm should run in O(n) complexity.
 */
/*
 *	˼·������ÿ��Ԫ�أ�Ѱ�Ҹ�ֵ��ߵ�Ԫ�ظ������ұߵ�Ԫ�ظ���
 */
import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		for (int e : num)
			set.add(e);
		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
            set.remove(e);
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(count, max);
		}
		return max;
    }
}
