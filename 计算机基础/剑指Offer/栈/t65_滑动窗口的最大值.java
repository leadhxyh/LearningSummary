/*
 *	给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

import java.util.*;
/**
用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
1.判断当前最大值是否过期
2.新增加的值从队尾开始比较，把所有比他小的值丢掉
*/
public class Solution {
   public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
       	//保存当前窗口的起始下标：{2,[3,4,2],6,2,5,1}时begin为1
        int begin; 
       	//保存可能成为最大值的下标
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            
            if(q.isEmpty())
                q.add(i);
            //最大值超出窗口范围，将其删除
            else if(begin > q.peekFirst())
                q.pollFirst();
         	//弹出小于新元素的下标
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            //将新元素下标加入双端队列
            q.add(i);  
            //保存当前窗口最大的元素
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
