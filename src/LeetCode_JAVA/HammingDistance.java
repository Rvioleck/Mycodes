package LeetCode_JAVA;

import org.junit.Test;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = 0, _x, _y;
        while (x != 0 || y != 0) {
            _x = x & 1;
            _y = y & 1;
            if (_x != _y)
                res++;
            x >>= 1;
            y >>= 1;
        }
        return res;
    }

    @Test
    public void test() {
        HammingDistance obj = new HammingDistance();
        int x = 5, y = 9;
        System.out.println(obj.hammingDistance(x, y));
    }

}
