/*
 *	Given a collection of integers that might contain duplicates, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

For example,
If S =[1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

/*
 *	˼·������num[i]Ԫ�أ�����Ԫ�ؼӵ�num[i-1]���ɵ��Ӽ��ĺ��棬����һЩ�µ��Ӽ�������Щ�Ӽ����뵽�ܵĽ����
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		//�ȶ�num����
		Arrays.sort(num);
		//�����Ѿ���ӵ��Ӵ�����ֹ�ظ����
		Set<ArrayList<Integer>> s = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
        	if (i == 0) {
        		ArrayList<Integer> empty = new ArrayList<>();
        		ans.add(empty);	//�մ�
        		s.add(empty);
        		ArrayList<Integer> one = new ArrayList<>();
        		one.add(num[i]);
        		ans.add(one);
        		s.add(one);
        	} else {
        		ArrayList<ArrayList<Integer>> newSubSets = new ArrayList<>();
				//����ԭ���Ӽ����ϵ�ǰ���������µ��Ӽ�
        		for (ArrayList<Integer> oldSubSet : ans) {
        			ArrayList<Integer> newSubSet = new ArrayList<>(oldSubSet);
        			newSubSet.add(num[i]);
        			if (!s.contains(newSubSet)) {
        				s.add(newSubSet);
        				newSubSets.add(newSubSet);
        			}
        		}
        		ans.addAll(newSubSets);
        	}
        }
        return ans;
    }
}
