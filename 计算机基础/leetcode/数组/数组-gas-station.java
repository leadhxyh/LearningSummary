/*
 *	There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note: 
The solution is guaranteed to be unique.
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //遍历每个加油站
        for (int i = 0; i < gas.length; i++) {
            //保存当前的油量
            int tank = gas[i];
            int moves = 0;
            //从当前加油站出发，终止条件是：1.重新回到原点（moves==length）,2.油量不足
            for (int j = i; moves < gas.length && tank >= cost[j]; j = (j+1)%gas.length) {
                moves++;
                tank -= cost[j];
                tank += gas[(j+1)%gas.length];
            }
            //如果重新回到原点，则返回
            if (moves == gas.length)
                return i;
        }
        return -1;
    }
}
