package LeetCode_JAVA.TwoPointer.BinarySearch;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 给定两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 */
public class Divide {

    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(new Divide().divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        long x = dividend, y = divisor;
        boolean isNeg = false;
        if (x < 0 && y > 0 || x > 0 && y < 0){
            isNeg = true;
        }
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        long left = 0, right = x;
        while (left < right){
            long mid = left + right + 1 >> 1;
            if (mul(mid, y) <= x){
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        long ans = isNeg ? -left : left;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }

    /**
     * @param a 数a
     * @param k 数k
     * @return a * k
     * 类似于快速幂，称为快速乘法
     */
    public long mul(long a, long k){
        long ans = 0;
        while (k != 0){
            if ((k & 1) == 1){
                ans += a;
            }
            k >>= 1;
            a += a;
        }
        return ans;
    }


}
