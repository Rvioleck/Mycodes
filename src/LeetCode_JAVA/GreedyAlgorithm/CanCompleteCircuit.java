package LeetCode_JAVA.GreedyAlgorithm;

/**
 * https://leetcode-cn.com/problems/gas-station/
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tankGas = 0;    // 记录当前油箱油量
        int allGas = 0;     // 记录最后的油量剩余
        int curIndex = 0;   // 记录车站结果
        for (int i = 0; i < n; i++) {
            int leftGas = gas[i] - cost[i]; // 记录每趟行程消耗(累计)油量
            allGas += leftGas;
            tankGas += leftGas;
            if (tankGas <= 0 && i != n - 1) { // 当前油箱小于0时，之前的开始车站不合理
                curIndex = i + 1;
                tankGas = 0;
            }
        }
        return allGas < 0 ? -1 : curIndex;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));
    }
}
