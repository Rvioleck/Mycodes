package LeetCode_JAVA;

import org.junit.Test;

public class MaxProfit {
    public int maxProfit(int[] prices){
        if (prices.length == 0){
            return 0;
        }
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                dp[i] = prices[i] - prices[i - 1];
            }
            prices[i] = Math.min(prices[i], prices[i - 1]);
        }
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (result < dp[i])
                result = dp[i];
        }
        return result;
    }

    @Test
    public void test(){
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
