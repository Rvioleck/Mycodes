package LeetCode_JAVA.BitwiseOperation;

import org.junit.Test;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int count = 32;
        while (count-- != 0) {
            int digit = n & 1;
            result = (result << 1) + digit;
            n >>= 1;
        }
        return result;
    }

    @Test
    public void test() {
        int n = 0b11111111111111111111111111111101;
        int result = reverseBits(n);
        System.out.println(result);
    }
}
