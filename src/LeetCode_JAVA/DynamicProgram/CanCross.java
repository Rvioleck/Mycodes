package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/frog-jump/
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，
 * 并且在每一个单元格内都有可能放有一块石子（也有可能没有）。青蛙可以跳上石子，但是不可以跳入水中。
 * 给你石子的位置列表 stones（用单元格序号 升序 表示），
 * 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位
 * （即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。
 * 另请注意，青蛙只能向前方（终点的方向）跳跃。
 */
public class CanCross {

    public static void main(String[] args) {
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(new CanCross().canCross(stones));
    }

    public boolean canCross(int[] stones) {
        // dp[i][k] 表示青蛙能否达到「现在所处的石子编号」为 i 且「上一次跳跃距离」为 k 的状态。
        int n = stones.length;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) break;
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
