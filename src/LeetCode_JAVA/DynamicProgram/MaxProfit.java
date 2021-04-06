package LeetCode_JAVA.DynamicProgram;


/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * dp[i][j]：下标为 i(1<=i<=n) 这一天结束的时候，手上持股状态为j时，我们持有的现金数。
 * 共含有两个状态：j = 1表示当前持股，j = 0时表示当前不持股
 * 今天不持股时 dp[i][0] = max(dp[i - 1][1] + prices[i - 1], dp[i - 1][0])
 * 前者为昨日持股并在昨日结束时卖掉, 后者为昨日不持股，什么都没做
 * 今天持股时 dp[i][1] = max(-prices[i - 1], dp[i - 1][1])
 * 前者为昨日不持股并在昨日结束时买入(因为只能一次买入，所以买入后现金必为-prices[i - 1]), 后者为昨日持股，什么都没做
 *
 * 初始条件 dp[1][1] = -prices[0], 第一天结束之后持股，现金为负的第一天股价(买入现金减少)
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit().maxProfit(prices));
        System.out.println(new MaxProfit().maxProfit_optimise(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i - 1], dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i - 1], dp[i - 1][1]);
        }
        return dp[n][0];
    }

    public int maxProfit_optimise(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp0 = Math.max(dp1 + prices[i - 1], dp0);
            dp1 = Math.max(-prices[i - 1], dp1);
        }
        return dp0;
    }
}
