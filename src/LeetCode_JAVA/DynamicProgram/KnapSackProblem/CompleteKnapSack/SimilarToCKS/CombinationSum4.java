package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack.SimilarToCKS;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * 给你一个由 不同 整数组成的数组 nums，和一个目标整数 target。请你从 nums 中找出并返回总和为target的元素组合的个数。
 * <p>
 * 输入数组的每个元素可以使用多次，这一点和「完全背包」问题有点像（与518零钱兑换的一维递推式相同仅为滚动数组压缩后的巧合）；
 * 顺序不同的序列被视作不同的排列组合，这一点和所有的「背包问题」都不同，个人认为其不为「完全背包」问题
 * dp[i]：对于给定的由正整数组成且不存在重复数字的数组，和为 i 的组合的个数。
 * 状态转移方程：dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
 */
public class CombinationSum4 {

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
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new CombinationSum4().combinationSum4(nums, 4));
    }

}
