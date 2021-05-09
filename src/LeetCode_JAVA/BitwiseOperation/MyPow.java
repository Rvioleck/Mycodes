package LeetCode_JAVA.BitwiseOperation;

import org.junit.Test;

public class MyPow {
    public double quickMultiply(double x, long n) {
        double result = 1;
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) { // 负指数幂
            n = -n;
            x = 1 / x;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }

    public double myPow(double x, int n) {
        long N = n;
        return quickMultiply(x, N);
    }


    @Test
    public void test() {
        System.out.println(myPow(1, 0));
        System.out.println(myPow(0, 0));
        System.out.println(myPow(0, 10));
        System.out.println(myPow(-3, 5));
        System.out.println(myPow(-0.5, 3));
        System.out.println(myPow(3, -3));
    }
}
