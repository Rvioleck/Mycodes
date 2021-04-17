package LeetCode_JAVA.DFS_BFS;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * 完全背包问题，回溯超时
 * dp[i] = dp[i - num[0]] + dp[i - num[1]] + .. + dp[i - num[n - 1]]
 */
public class Combination4 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Combination4().combinationSum4(new int[]{1, 2, 3}, 4));
    }


    /*
    / 回溯超时
     private int target;
     private int count = 0;
     private void dfs(int[] nums, int sum){
         if (sum == target){
             count++;
             return;
         }

         for (int i = 0; i < nums.length; i++) {
             if (sum > target) continue;
             sum += nums[i];
             dfs(nums, sum);
         }
     }

     public int combinationSum4(int[] nums, int target) {
         this.target = target;
         dfs(nums, 0);
         return count;
     }
    */

}
