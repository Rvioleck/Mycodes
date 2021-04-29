package LeetCode_JAVA.TwoPointer;

import org.junit.Test;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     *
     * @param nums 待去重数组
     * @return 排序后无重复元素的下标终点
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < 1 || nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }


    @Test
    public void test() {
//        String s = "abbaca";
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int n = removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
