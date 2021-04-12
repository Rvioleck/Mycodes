package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/submissions/
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 */
public class WaysToStep {

    public int waysToStep(int n) {
        int dp1 = 1, dp2 = 2, dp3 = 4;
        if (n == 1) {
            return dp1;
        }
        if (n == 2) {
            return dp2;
        }
        if (n == 3) {
            return dp3;
        }
        for (int i = 4; i <= n; ++i) {
            int dpNext = (dp1 + dp2) % 1000000007 + dp3;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dpNext % 1000000007;
        }
        return dp3;
    }

    public static void main(String[] args) {
        System.out.println(new WaysToStep().waysToStep(9999999));
    }
}
