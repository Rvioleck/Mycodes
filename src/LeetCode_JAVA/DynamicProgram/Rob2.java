package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * dp[i] = max(dp[i - 2] + num, dp[i - 1])  0 <= i < n
 */
public class Rob2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int[] dp_h = new int[n + 1];
        dp_h[1] = nums[0]; // 考虑第一间房屋，初始化为第一间
        int[] dp_t = new int[n + 1];
        dp_t[2] = nums[1]; // 不考虑第一间房屋，初始化为第二间

        for (int i = 2; i <= n; i++) { // 2~n-1, 3~n
            int num = nums[i - 1];
            if (i <= n - 1){ // dp_h为考虑头部第一间房屋，不考虑最后一间房屋时的最优解(2~n-1间)
                dp_h[i] = Math.max(dp_h[i - 1], dp_h[i - 2] + num);
            }
            if (i >= 3){     // dp_t为考虑尾部最后一间房屋，不考虑第一间房屋时的最优解(3~n间)
                dp_t[i] = Math.max(dp_t[i - 1], dp_t[i - 2] + num);
            }
        }
        return Math.max(dp_h[n - 1], dp_t[n]);
    }

    public int rob_optimise(int[] nums){
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int dp_h0 = 0, dp_h1 = nums[0], dp_h2;
        int dp_t0 = 0, dp_t1 = nums[1], dp_t2;

        for (int i = 2; i <= n; i++) { // 2~n-1, 3~n
            int num = nums[i - 1];
            if (i <= n - 1){ // dp_h为考虑头部第一间房屋，不考虑最后一间房屋时的最优解(2~n-1间)
                dp_h2 = Math.max(dp_h1, dp_h0 + num);
                dp_h0 = dp_h1;
                dp_h1 = dp_h2;
            }
            if (i >= 3){     // dp_t为考虑尾部最后一间房屋，不考虑第一间房屋时的最优解(3~n间)
                dp_t2 = Math.max(dp_t1, dp_t0 + num);
                dp_t0 = dp_t1;
                dp_t1 = dp_t2;
            }
        }
        return Math.max(dp_h1, dp_t1);
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(new Rob2().rob(nums));
        System.out.println(new Rob2().rob_optimise(nums));
    }

}
