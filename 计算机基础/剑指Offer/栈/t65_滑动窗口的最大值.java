/*
 *	����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */

import java.util.*;
/**
��һ��˫�˶��У����е�һ��λ�ñ��浱ǰ���ڵ����ֵ�������ڻ���һ��
1.�жϵ�ǰ���ֵ�Ƿ����
2.�����ӵ�ֵ�Ӷ�β��ʼ�Ƚϣ������б���С��ֵ����
*/
public class Solution {
   public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
       	//���浱ǰ���ڵ���ʼ�±꣺{2,[3,4,2],6,2,5,1}ʱbeginΪ1
        int begin; 
       	//������ܳ�Ϊ���ֵ���±�
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            
            if(q.isEmpty())
                q.add(i);
            //���ֵ�������ڷ�Χ������ɾ��
            else if(begin > q.peekFirst())
                q.pollFirst();
         	//����С����Ԫ�ص��±�
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            //����Ԫ���±����˫�˶���
            q.add(i);  
            //���浱ǰ��������Ԫ��
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
