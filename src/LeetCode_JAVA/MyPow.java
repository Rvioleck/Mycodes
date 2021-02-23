package LeetCode_JAVA;

import org.junit.Test;

public class MyPow {
    public double quickMultiply(double x, long n) {
        double result = 1;
        int tag;
        if (n == 0 || x == 1) {
            return 1;
        }
        double temp = x;
        if (n < 0) {
            n = -n;
            temp = 1 / x;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
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
        double x = 2;
        int n = 0;
        System.out.println(myPow(x, n));
    }
}
