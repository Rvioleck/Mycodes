package LeetCode_JAVA;

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

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int removeNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                ++removeNum;
            } else
                nums[i + 1 - removeNum] = nums[i + 1];
        }
        return nums.length - removeNum;
    }


    @Test
    public void test() {
//        String s = "abbaca";
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
