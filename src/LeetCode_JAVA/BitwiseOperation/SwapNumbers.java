package LeetCode_JAVA.BitwiseOperation;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/swap-numbers-lcci/
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 */
public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        // a ^ a = 0, a ^ 0 = a, a ^ 1 = ~a, 异或满足交换律和结合律
        numbers[0] ^= numbers[1]; // a = a ^ b
        numbers[1] ^= numbers[0]; // b = a ^ b ^ b = a
        numbers[0] ^= numbers[1]; // a = a ^ b ^ a = b
        return numbers;
    }

    public static void main(String[] args) {
        int[] nums = {1, 200};
        System.out.println(Arrays.toString(new SwapNumbers().swapNumbers(nums)));
    }
}
