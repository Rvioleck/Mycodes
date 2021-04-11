package LeetCode_JAVA.Greedy_Algorithm;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m2 = 1, m3 = 1, m5 = 1;
        for (int i = 2; i <= n; i++) {
            int ugly = Math.min(dp[m2] * 2, Math.min(dp[m3] * 3, dp[m5] * 5));
            if (ugly == dp[m2] * 2){
                m2++;
            }
            if (ugly == dp[m3] * 3){
                m3++;
            }
            if (ugly == dp[m5] * 5){
                m5++;
            }
            dp[i] = ugly;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(new NthUglyNumber().nthUglyNumber(n));
    }

}
