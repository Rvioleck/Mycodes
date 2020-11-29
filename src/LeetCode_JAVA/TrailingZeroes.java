package LeetCode_JAVA;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrailingZeroes {
    public int trailingZeroes(int n){
        int res = 0;
        for (int i = 5; i <= n; i += 5) {
            int factor = i;
            while(factor % 5 == 0){
                res += 1;
                factor /= 5;
            }
        }
        return res;
    }

    @Test
    public void test(){
        assertEquals(trailingZeroes(25), 6);

    }
}
