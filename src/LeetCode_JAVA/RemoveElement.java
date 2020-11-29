package LeetCode_JAVA;

import org.junit.Test;

public class RemoveElement {
    public int removeElement(int[] nums, int val){
        int afterLen = nums.length; // 动态指针保存大小
        for (int i = 0; i < afterLen; i++) {
            if (nums[i] == val){ // 找到元素时
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

    @Test
    public void test(){
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int[] nums = {4,9,9};
        int[] nums = {9};
        int len = removeElement(nums, 9);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] +" ");
        }
    }
}
