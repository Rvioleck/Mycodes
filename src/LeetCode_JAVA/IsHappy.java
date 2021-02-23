package LeetCode_JAVA;

import org.junit.Test;

public class IsHappy {
    public boolean isHappy(int n) {
        int low = next(n), fast = next(next(n));
        while (low != fast) {
            if (low == 1 || fast == 1)
                return true;
            low = next(low);
            fast = next(next(fast));
        }
        if (low == 1)
            return true;
        else
            return false;
    }

    @Test
    public void isHappyTest() {
        int n = 100;
        System.out.println(isHappy(n));
    }

    public int next(int n) {
        int result = 0;
        while (n != 0) {
            result += Math.pow(n % 10, 2);
            n /= 10;
        }
        return result;
    }

    @Test
    public void nextTest() {
        int n = 100;
        System.out.println(next(n));
    }
}
