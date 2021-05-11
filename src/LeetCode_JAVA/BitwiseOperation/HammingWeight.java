package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += ((n&1) == 1) ? 1 : 0;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hm = new HammingWeight();
        int a = 0b00000000000000000000000000001011;
        System.out.println(hm.hammingWeight(a));
    }
}
