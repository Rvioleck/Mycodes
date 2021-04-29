package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * <p>
 * dp[i]: 第1~i个字符所构成的编码的解码组合个数
 * dp[i] = dp[i - 1] 当s[i - 1] != '0'
 * dp[i] += dp[i - 2] 当s[i - 2] != '0'且 (int)(10 * s[i - 2] + s[i - 1]) <= 26
 * <p>
 * 初始条件：dp[0] = 1 空字符串解码有一种结果
 * 若第一个字符不为'0': dp[1] = 1 一个字符有解码有一种结果
 * 若第一个字符为'0': dp[1] = 0 前导0没有解码结果
 */
public class NumDecodings {

    public static void main(String[] args) {
        String str = "2412951852199";
        System.out.println(new NumDecodings().numDecodings(str));
        System.out.println(new NumDecodings().numDecodings_optimise(str));
    }

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }
        for (int i = 2; i <= len; i++) {
            char ch = s.charAt(i - 1);
            char preCh = s.charAt(i - 2);
            if (ch != '0') {
                dp[i] = dp[i - 1];
            }
            if (preCh != '0' && 10 * (preCh - '0') + ch - '0' <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public int numDecodings_optimise(String s) {
        int len = s.length();
        int dp0 = 1, dp1 = 0, dp2 = 0;
        if (s.charAt(0) != '0') {
            dp1 = 1;
        }
        for (int i = 2; i <= len; i++) {
            char ch = s.charAt(i - 1);
            char preCh = s.charAt(i - 2);
            if (ch != '0') {
                dp2 = dp1;
            }
            if (preCh != '0' && 10 * (preCh - '0') + ch - '0' <= 26) {
                dp2 += dp0;
            }
            dp0 = dp1;
            dp1 = dp2;
            dp2 = 0;
        }
        return dp1;
    }

}
