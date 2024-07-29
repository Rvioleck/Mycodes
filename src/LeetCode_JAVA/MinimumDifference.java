package LeetCode_JAVA;

public class MinimumDifference {

    public int minimumDifference(int[] nums, int k) {
        int[] preOr = new int[nums.length];
        preOr[0] = nums[0];
        int minAbs = Math.abs(nums[0] - k);
        for (int i = 1; i < nums.length; ++i) {
            preOr[i] = preOr[i - 1] | nums[i];
            minAbs = Math.min(minAbs, Math.abs(preOr[i] - k));
        }
        for (int left = 0; left < nums.length; ++left) {
            int right = nums.length - 1;
            int mid = (left + right + 1) / 2;
            while (mid < right) {
                int xor = preOr[mid] - preOr[left];  // left + 1, ..., mid
                minAbs = Math.min(minAbs, Math.abs(xor - k));
                if (xor < k) {
                    mid = (right + mid + 1) / 2;
                } else if (xor > k) {
                    right = mid;
                    mid = (left + mid + 1) / 2;
                } else {
                    return 0;
                }
            }
        }
        return minAbs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 3};
        int k = 2;
        System.out.println(new MinimumDifference().minimumDifference(nums, k));
    }
}
