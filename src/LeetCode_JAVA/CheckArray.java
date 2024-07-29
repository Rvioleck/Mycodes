package LeetCode_JAVA;

public class CheckArray {

    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] d = new int[n + 1];
        d[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            d[i] = nums[i] - nums[i - 1];
        }
        int dSum = 0;
        for (int i = 0; i < n - k + 1; ++i) {
            if (d[i] < 0) return false;
            if (d[i] == 0) continue;
            int need = d[i];
            d[i] -= need;
            d[i + k] += need;
            dSum += d[i];
        }
        for (int i = 0; i < n; ++i) {
            if (d[i] != 0) return false;
        }
        return dSum == 0;

//        for (int i = 0; i < nums.length - k + 1; ++i) {
//            if (nums[i] < 0) return false;
//            if (nums[i] == 0) continue;
//            for (int j = i + 1; j < i + k; ++j) {
//                nums[j] -= nums[i];
//            }
//            nums[i] = 0;
//        }
//        for (int i = nums.length - k; i < nums.length; ++i) {
//            if (nums[i] != 0) return false;
//        }
//        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3,7};
        System.out.println(new CheckArray().checkArray(nums, 2));
    }
}
