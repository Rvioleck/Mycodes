package LeetCode_JAVA.BitwiseOperation;

import java.util.Arrays;

public class SingleNumber3 {

//    https://leetcode-cn.com/problems/single-number-iii/
//    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

   public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(Arrays.toString(new SingleNumber3().singleNumber(nums)));
    }

    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int num: nums){
            eor ^= num;
        }
        // ~eor+1为eor的补码
        // 补码和原码按位与可以得到最右侧的1
        int rightOne = eor & (~eor + 1); // 提取最右侧的1
        int eor_ = 0;
        for (int num: nums){
            if ((num & rightOne) == rightOne){ // (num & rightOne) == 0
                eor_ ^= num;
            }
        }
        return new int[]{eor_, eor^eor_};
    }
}
