package LeetCode_JAVA;

import org.junit.Test;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isGood(int num) {
        String str = String.valueOf(num);
        if (str.indexOf("3") >= 0
                || str.indexOf("4") >= 0
                || str.indexOf("7") >= 0) {
            return false;
        }
        if (str.indexOf("2") >= 0
                || str.indexOf("5") >= 0
                || str.indexOf("6") >= 0
                || str.indexOf("9") >= 0) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        int num = 10;
        System.out.println(rotatedDigits(num));
    }
}
