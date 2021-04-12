package LeetCode_JAVA.DynamicProgram.MaxProfit;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。返回获得利润的最大值。
 * <p>
 * dp[i][j]：下标为 i(1<=i<=n) 这一天结束的时候，手上持股状态为j时，我们持有的现金数。
 * j = 0 表示当前不持股， j = 1 表示当前持股
 * <p>
 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee) 交易结束后产生手续费
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1])
 * <p>
 * 初始条件：dp[0][1] = -prices[0] - 2;
 */
public class MaxProfit6 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new MaxProfit6().maxProfit(prices, fee));
        System.out.println(new MaxProfit6().maxProfit_optimise(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public int maxProfit_optimise(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i - 1] - fee);
            dp1 = Math.max(dp1, dp0 - prices[i - 1]);
        }
        return Math.max(dp0, dp1);
    }

}
