package LeetCode_JAVA;

public class Combination4 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Combination4().combinationSum4(new int[]{1, 2, 3}, 4));
    }


    /// 回溯超时
//    private int target;
//    private int count = 0;
//    private void dfs(int[] nums, int sum){
//        if (sum == target){
//            count++;
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (sum > target) continue;
//            sum += nums[i];
//            dfs(nums, sum);
//            sum -= nums[i];
//        }
//    }
//
//    public int combinationSum4(int[] nums, int target) {
//        this.target = target;
//        dfs(nums, 0);
//        return count;
//    }
//

}
