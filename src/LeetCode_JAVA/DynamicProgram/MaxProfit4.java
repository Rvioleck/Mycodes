package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * dp[i][j]: 下标为i(1 <= i <= n)这一天结束的时候，手上的持股状态为j时，我们持有的现金数。
 * 共有2k+1种状态：
 * j = 0 时表示当前未交易不持股，j = 1时表示当前购买第一次持股，j = 2表示当前出售第一次不持股
 * j = 3表示当前第二次购买持股, j = 4表示当前第二次出售不持股 ...
 * j = 2k-1 表示第k次购买持股, j = 2k表示第k次出售不持股
 *
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1])
 * dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i - 1])
 * dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i - 1])
 * dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i - 1])
 * ...  ... = ... ...
 * dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - price);
 * dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + price); 其中j = 1, 3, 5, ..., 2*k+1
 *
 * 初始条件： dp[1][1] = dp[1][3] = ... = dp[1][2*k-1] = -prices[0];
 */
public class MaxProfit4 {

    public int maxProfit(int k, int[] prices){
        int n = prices.length;
        if (k == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[n + 1][2 * k + 1];
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[1][i] = -prices[0];
        }
        for (int i = 2; i <= n; i++) {
            int price = prices[i - 1];
            for (int j = 1; j <= 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - price);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + price);
            }
        }
        return dp[n][2 * k];
    }

    public int maxProfit_optimise(int k, int[] prices){
        int n = prices.length;
        if (k == 0 || n == 0){
            return 0;
        }
        int[] dp = new int[2 * k + 1];
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[i] = -prices[0];
        }
        for (int i = 2; i <= n; i++) {
            int price = prices[i - 1];
            for (int j = 1; j <= 2 * k; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - price);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + price);
            }
        }
        return dp[2 * k];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,6,5,0,3};
        int k = 2;
        System.out.println(new MaxProfit4().maxProfit(k, prices));
        System.out.println(new MaxProfit4().maxProfit_optimise(k, prices));
        System.out.println(new MaxProfit3().maxProfit(prices));
    }

}
