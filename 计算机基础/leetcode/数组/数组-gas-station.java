/*
 *	There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note: 
The solution is guaranteed to be unique.
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //����ÿ������վ
        for (int i = 0; i < gas.length; i++) {
            //���浱ǰ������
            int tank = gas[i];
            int moves = 0;
            //�ӵ�ǰ����վ��������ֹ�����ǣ�1.���»ص�ԭ�㣨moves==length��,2.��������
            for (int j = i; moves < gas.length && tank >= cost[j]; j = (j+1)%gas.length) {
                moves++;
                tank -= cost[j];
                tank += gas[(j+1)%gas.length];
            }
            //������»ص�ԭ�㣬�򷵻�
            if (moves == gas.length)
                return i;
        }
        return -1;
    }
}
