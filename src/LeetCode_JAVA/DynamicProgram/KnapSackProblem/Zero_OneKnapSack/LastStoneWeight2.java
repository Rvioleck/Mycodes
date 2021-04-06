package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

/**
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * dp[i][j]表示前i个物品(下标为1到i)，放进容量为j的背包的时候的最大容量
 * 等价为0-1背包问题，结果为sumWeight - 2*dp[sumWeight / 2]
 */
public class LastStoneWeight2 {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int allWeight = 0;
        for (int stone : stones) {
            allWeight += stone;
        }
        int m = allWeight / 2;
        int[][] dp = new int[n + 1][allWeight + 1];
        for (int i = 1; i <= n; i++) {
            int stone = stones[i - 1];
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stone) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stone] + stone);
                }
            }
        }
        return allWeight - 2 * dp[n][m];
    }

    public int lastStoneWeightII_optimise(int[] stones) {
        // 二维数组的等价变换，等价于0-1背包问题，内循环需要反向遍历
        int n = stones.length;
        int allWeight = 0;
        for (int stone : stones) {
            allWeight += stone;
        }
        int m = allWeight / 2;
        int[] dp = new int[allWeight + 1];
        for (int i = 1; i <= n; i++) {
            int stone = stones[i - 1];
            for (int j = m; j >= 0; j--) {
                if (j >= stone) {
                    dp[j] = Math.max(dp[j], dp[j - stone] + stone);
                }
            }
        }
        return allWeight - 2 * dp[m];
    }

    public static void main(String[] args) {
        int[] stones = new int[]{
                57, 32, 40, 27, 35, 61
        };
        System.out.println(new LastStoneWeight2().lastStoneWeightII(stones));
        System.out.println(new LastStoneWeight2().lastStoneWeightII_optimise(stones));
    }

}
