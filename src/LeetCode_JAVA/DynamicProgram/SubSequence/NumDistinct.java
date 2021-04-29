package LeetCode_JAVA.DynamicProgram.SubSequence;

/**
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * 例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是
 * <p>
 * 解题逻辑变为：s有几种删除元素的方法使得其变为t
 * <p>
 * dp[i][j]: 只考虑s的前i+1个元素(0~i)和t的前j+1个元素(0~j)的情况下，t的出现次数
 * s[i] == t[j]时：dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
 * s[i] != t[j]时：dp[i][j] = dp[i - 1][j]
 * <p>
 * 初始条件：dp[i][0] = 1 (0 <= i <= m) 如果t串为空，则只有一种方法把s变为t(删除所有元素)
 * <p>
 * 先看s[i] == t[j] 时，以s = "rara" t = "ra" 为例，当i = 3, j = 1时，s[i] == t[j]。
 * 此时分为2种情况，s串用最后一位的a + 不用最后一位的a。
 * 如果用s串最后一位的a,那么t串最后一位的a也被消耗掉，此时的子序列其实=dp[i-1][j-1]
 * 如果不用s串最后一位的a，那就得看"rar"里面是否有"ra"子序列的了，就是dp[i-1][j]
 * 所以 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 * 再看s[i] != t[j] 比如 s = "rarb" t = "ra" 还是当i = 3, j = 1时，s[i] != t[j]
 * 此时显然最后的b想用也用不上啊。所以只能指望前面的"rar"里面是否有能匹配"ra"的
 * 所以此时dp[i][j] = dp[i-1][j]
 */
public class NumDistinct {

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(new NumDistinct().numDistinct(s, t));
        System.out.println(new NumDistinct().numDistinct_optimise(s, t));
    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
            int a = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int b = t.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinct_optimise(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            int a = s.charAt(i - 1);
            for (int j = n; j >= 1; j--) {
                int b = t.charAt(j - 1);
                if (a == b) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}
