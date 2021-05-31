package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/power-of-four/submissions/
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 */
public class IsPowerOfFour {

    public static void main(String[] args){
        int n = 0;
        System.out.println(new IsPowerOfFour().isPowerOfFour(n));
    }
    
    public boolean isPowerOfFour(int n) {
        return n > 0 && (0x55555555 & n) == n && (n & (n - 1)) == 0;
    }
    
}
