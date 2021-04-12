package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

public class SortColors {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int red = 0, blue = n - 1;
        for (int i = 0; i < blue; i++) {
            while (i <= blue && nums[i] == 2) { // 直到尾部不是2停止
                swap(nums, i, blue--);
            }
            if (nums[i] == 0) {
                swap(nums, i, red++);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0, 2, 1, 0, 0, 1, 2, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
