package LeetCode_JAVA.DynamicProgram;


/**
 * https://leetcode-cn.com/problems/house-robber/solution/
 *你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * dp[i]：考虑前i所房屋（下标1~i）以内的房屋，最多可以偷窃的金额为dp[i]
 * dp[i] = Math.max(dp[i - 1], dp[i - 2] + num);
 */
public class Rob {

    public int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            int num = nums[i - 1];
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num);
        }
        return dp[n];
    }

    public int rob_optimise(int[] nums){
        int n = nums.length;
        int dp0 = 0, dp1 = nums[0], dp2;
        for (int i = 2; i <= n; i++) {
            int num = nums[i - 1];
            dp2 = Math.max(dp1, dp0 + num);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(new Rob().rob(nums));
        System.out.println(new Rob().rob_optimise(nums));
    }

}
