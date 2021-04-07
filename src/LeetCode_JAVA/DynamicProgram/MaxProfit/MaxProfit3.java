package LeetCode_JAVA.DynamicProgram.MaxProfit;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * dp[i][j]: 下标为i(1 <= i <= n)这一天结束的时候，手上的持股状态为j时，我们持有的现金数。
 * 共有五种状态：j = 0 时表示当前未交易不持股，j = 1时表示当前购买第一次持股，
 * j = 2表示当前出售第一次不持股，j = 3表示当前第二次购买持股, j = 4表示当前第二次出售不持股
 * <p>
 * dp[i][0] = dp[i - 1][0]
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1])
 * dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i - 1])
 * dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i - 1])
 * dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i - 1])
 * <p>
 * 初始条件： dp[1][1] = -prices[0]  dp[1][3] = -prices[0];
 */
public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][5];
        dp[1][1] = -prices[0];
        dp[1][3] = -prices[0];  // 第一天也可以进行第二次买入操作(第一天买->卖->买)该初始化很重要
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i - 1]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i - 1]);
        }
        return dp[n][4];
    }

    public int maxProfit_optimise(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0], dp2 = 0, dp3 = -prices[0], dp4 = 0;
        for (int i = 2; i <= n; i++) {
            int price = prices[i - 1];
            dp1 = Math.max(dp1, dp0 - price);
            dp2 = Math.max(dp2, dp1 + price);
            dp3 = Math.max(dp3, dp2 - price);
            dp4 = Math.max(dp4, dp3 + price);
        }
        return dp4;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(new MaxProfit3().maxProfit(prices));
        System.out.println(new MaxProfit3().maxProfit_optimise(prices));
    }
}
