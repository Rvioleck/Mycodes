package LeetCode_JAVA.DynamicProgram;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0){
            return 0;
        }
        int[] dp = new int[len];
        int res = 0;
        for (int i = 1; i < len; ++i) {
            if (s.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && s.charAt(pre) == '('){
                    dp[i] = dp[i - 1] + 2 + (pre >= 1 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }

}
