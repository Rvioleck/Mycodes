package LeetCode_JAVA;

import org.junit.Test;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int sLen = s.length;
        int gLen = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        if (sLen == 0 || gLen == 0)
            return 0;
        int count = 0;
        while (sLen > 0 && gLen > 0) {
            if (s[sLen - 1] >= g[gLen - 1]) {
                sLen--;
                gLen--;
                count++;
            } else if (s[sLen - 1] < g[gLen - 1]) {
                gLen--;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

}
