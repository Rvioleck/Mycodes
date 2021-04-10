package LeetCode_JAVA;


/**
 * https://leetcode-cn.com/problems/ugly-number/comments/
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class IsUgly {

    public static void main(String[] args) {
        int num = 17;
        System.out.println(new IsUgly().isUgly(num));
    }

    public boolean isUgly(int n) {
        if (n < 1) return false;
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n >>= 1;
        }
        return n == 1;
    }
}
