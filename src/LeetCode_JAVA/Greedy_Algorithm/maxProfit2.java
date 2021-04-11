package LeetCode_JAVA.Greedy_Algorithm;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class maxProfit2 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; ++i){
            int deltaPrice = prices[i] - prices[i - 1];
            if (deltaPrice > 0){
                profit += deltaPrice;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new maxProfit2().maxProfit(prices));
    }

}
