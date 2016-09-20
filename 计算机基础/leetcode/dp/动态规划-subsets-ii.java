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
 *	思路：对于num[i]元素，将该元素加到num[i-1]生成的子集的后面，生成一些新的子集，将这些子集加入到总的结果中
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		//先对num排序
		Arrays.sort(num);
		//保存已经添加的子串，防止重复添加
		Set<ArrayList<Integer>> s = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
        	if (i == 0) {
        		ArrayList<Integer> empty = new ArrayList<>();
        		ans.add(empty);	//空串
        		s.add(empty);
        		ArrayList<Integer> one = new ArrayList<>();
        		one.add(num[i]);
        		ans.add(one);
        		s.add(one);
        	} else {
        		ArrayList<ArrayList<Integer>> newSubSets = new ArrayList<>();
				//根据原有子集加上当前整数生成新的子集
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
