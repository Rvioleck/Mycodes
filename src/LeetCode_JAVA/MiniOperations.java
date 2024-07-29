package LeetCode_JAVA;

public class MiniOperations {

    public long minimumOperations(int[] nums, int[] target) {
        int n = target.length;
        target[0] -= nums[0];
        nums[0] = target[0];
        for (int i = 1; i < n; ++i) {
            target[i] -= nums[i];
            nums[i] = target[i] - target[i - 1];
        }
        long count = 0;
        int acc_pos = 0;
        int acc_neg = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                if (acc_neg + nums[i] < 0) {
                    acc_neg += nums[i];
                    nums[i] = 0;
                } else {
                    nums[i] += acc_neg;
                    acc_neg = 0;
                }
                acc_pos += nums[i];
            } else if (nums[i] < 0) {
                if (acc_pos + nums[i] > 0) {
                    acc_pos += nums[i];
                    nums[i] = 0;
                } else {
                    nums[i] += acc_pos;
                    acc_pos = 0;
                }
                acc_neg += nums[i];
            }
            count += Math.abs(nums[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int[] target = {7, 6, 5};
        System.out.println(new MiniOperations().minimumOperations(nums, target));
    }
}
