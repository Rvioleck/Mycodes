package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
 * <p>
 * 其为二维费用的0-1背包问题
 */
public class FindMaxForm {

    /**
     * @param strs 二进制字符串数组
     * @param m    整数m
     * @param n    整数n
     * @return 返回 strs的最大子集的大小，该子集中最多有m个0和n个1
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0, one = 0, len = str.length();
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "10", "0001", "111001", "1", "0"
        };
        int m = 5, n = 3;
        System.out.println(new FindMaxForm().findMaxForm(strs, m, n));
    }

}
