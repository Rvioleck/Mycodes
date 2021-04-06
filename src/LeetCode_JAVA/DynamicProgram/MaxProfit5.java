package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * dp[i][j]：下标为 i(1<=i<=n) 这一天结束的时候，手上持股状态为j时，我们持有的现金数。
 * <p>
 * 总共含有3种状态： j = 0时表示当前不持股，j = 1时表示当前正常持股，j = 2表示当前在冷却区不持股
 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2])
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1])
 * dp[i][2] = dp[i][1] + prices[i - 1]
 * <p>
 * 初始条件 dp[1][1] = -prices[0], 第一天结束之后持股，现金为负的第一天股价
 * <p>
 * 解集合：不持股情况的最大值max(dp[n][0], dp[n][2])
 */
public class MaxProfit5 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(new MaxProfit5().maxProfit(prices));
        System.out.println(new MaxProfit5().maxProfit_optimise(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][3];
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            dp[i][2] = dp[i - 1][1] + prices[i - 1]; // 此时的dp[i - 1][1]进行压缩时得保存上一状态的dp1
        }
        return Math.max(dp[n][0], dp[n][2]);
    }

    private int maxProfit_optimise(int[] prices) {
        // 等价变换减少空间的使用，其中每个状态的dp都生成一个副本保存上一层的状态
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0], dp2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp00 = Math.max(dp0, dp2);
            int dp11 = Math.max(dp1, dp0 - prices[i - 1]);
            int dp22 = dp1 + prices[i - 1];
            dp0 = dp00;
            dp1 = dp11;
            dp2 = dp22;
        }
        return Math.max(dp0, dp2);
    }


}
