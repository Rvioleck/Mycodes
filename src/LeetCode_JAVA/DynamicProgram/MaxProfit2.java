package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * dp[i][j]：下标为 i(1<=i<=n) 这一天结束的时候，手上持股状态为j时，我们持有的现金数。
 * 共含有两个状态：j = 1表示当前持股，j = 0时表示当前不持股
 * 今天不持股时 dp[i][0] = max(dp[i - 1][1] + prices[i - 1], dp[i - 1][0])
 * 前者为昨日持股并在昨日结束时卖掉, 后者为昨日不持股，什么都没做
 * 今天持股时 dp[i][1] = max(dp[i - 1][0] - prices[i - 1], dp[i - 1][1])
 * 前者为昨日不持股并在昨日结束时买入(因为不限买入次数，所以每次买入要累加之前的现金数), 后者为昨日持股，什么都没做
 * <p>
 * 初始条件 dp[1][1] = -prices[0], 第一天结束之后持股，现金为负的第一天股价
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit2().maxProfit(prices));
        System.out.println(new MaxProfit2().maxProfit_optimise(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i - 1], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i - 1], dp[i - 1][1]);
        }
        return dp[n][0];
    }

    public int maxProfit_optimise(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp0 = Math.max(dp1 + prices[i - 1], dp0);
            dp1 = Math.max(dp0 - prices[i - 1], dp1);
        }
        return dp0;
    }
}
