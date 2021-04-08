package LeetCode_JAVA.TwoPointer;


/**
 * https://leetcode-cn.com/problems/remove-element/
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * slow维护不含val的数组，fast遇到值为val的元素直接跳过
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int afterLen = nums.length; // 动态指针保存大小
        for (int i = 0; i < afterLen; i++) {
            if (nums[i] == val) { // 找到元素时
                while (nums[afterLen - 1] == val) { // 倒序查找非val的元素，赋值到前面
                    afterLen--; // 每找到一个val值动态大小-1
                    if (afterLen == 0) // 长度为0直接退出
                        return afterLen;
                }
                nums[i] = nums[afterLen - 1]; // 把后方赋值到前面
                if (afterLen > i) // 未超过遍历下标i时正常自减
                    afterLen--;
                if (afterLen == 0)
                    return afterLen;
            }
        }
        return afterLen; // 未找到val时默认返回原长度
    }

    public int removeElementTwoPointer(int[] nums, int val){
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if (val != nums[fast]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int[] nums = {4,9,9};
        int[] nums = {3,2,2,3};
        int len = new RemoveElement().removeElementTwoPointer(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
