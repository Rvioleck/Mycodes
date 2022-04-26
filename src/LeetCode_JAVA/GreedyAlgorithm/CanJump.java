package LeetCode_JAVA.GreedyAlgorithm;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class CanJump {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        System.out.println(new CanJump().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int leftJump = 0;
        for (int i = 0; i < n; ++i) {
            leftJump = Math.max(leftJump, nums[i]);
            if (leftJump <= 0 && i != n - 1) {
                return false;
            }
            leftJump--;

        }
        return true;
    }

}
