package LeetCode_JAVA.BitwiseOperation;

public class Shuffle {
    /*
    * https://leetcode.cn/problems/shuffle-the-array/
    * */

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; ++i){
            res[index] = nums[i];
            index += 2;
        }
        index = 1;
        for (int i = n; i < 2 * n; ++i){
            res[index] = nums[i];
            index += 2;
        }
        return res;
    }

    public int[] shuffle2(int[] nums, int n) {
        // nums中的数据<1000可以用每个数的第11~20位来存储新数据
        for (int i = 0; i < 2 * n; ++i){
            int newIndex = i < n ? 2 * i : (i - n) * 2 + 1;
            nums[newIndex] |= (nums[i] & 1023) << 10;
        }
        for (int i = 0; i < 2 * n; ++i){
            nums[i] >>= 10;
        }
        return nums;
    }
}
