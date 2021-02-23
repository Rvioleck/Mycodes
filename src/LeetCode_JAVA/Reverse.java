package LeetCode_JAVA;

import org.junit.Test;

public class Reverse {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;
            result = result * 10 + temp;
        }
        return result;
    }

    @Test
    public void test() {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
