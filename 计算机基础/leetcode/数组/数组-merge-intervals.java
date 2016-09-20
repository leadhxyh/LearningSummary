/*
Given a collection of intervals, merge all overlapping intervals.
For example,
Given[1,3],[2,6],[8,10],[15,18],
return[1,6],[8,10],[15,18].
 *	
 */

import java.util.*;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 1) {
            return intervals;
        }
        //����ʼλ�ý�������
        Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start < o2.start ? -1 : (o1.start == o2.start ? 0 : 1);
			}
		});
        
        ArrayList<Interval> ret = new ArrayList();
        Interval cur = null;
        for (int i = 0; i < intervals.size();) {
            //Ѱ�Ҵ�i��ʼ�����������䣨��i��j�����������䣩
            int maxEnd = intervals.get(i).end;
            int j = i+1;
            for (; j < intervals.size() &&
                 intervals.get(j).start <= maxEnd; j++ ) {
                if (intervals.get(j).end > maxEnd) {
                    maxEnd = intervals.get(j).end;
                }
            }
            //��������
            ret.add(new Interval(intervals.get(i).start, maxEnd));
            i = j;
        }
        return ret;
    }
}
