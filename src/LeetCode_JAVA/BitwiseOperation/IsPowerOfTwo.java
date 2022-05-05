package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/power-of-two/solution/
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(648));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int oneNum = 0;
        for (int i = 0; i <= 31; ++i){
            if (((n >> i) & 1) == 1){
                oneNum++;
            }
        }
        return oneNum == 1;
 /*
        return n > 0 && (n & -n) == n;
        return n > 0 && (n & (n - 1)) == 0;
        return n > 0 && (n & (~n + 1)) == n;
 */
    }

}
