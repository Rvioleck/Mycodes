package LeetCode_JAVA;

import org.junit.Test;

public class ShortestToChar {

    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        // 将字符C的位置的数初始化为0
        for (int i = 0; i < result.length; i++) {
            if (S.charAt(i) == C) {
                continue;
            }
            int left = i, right = i;
            int x = 0;
            while (S.charAt(left) != C && S.charAt(right) != C) {
                if (left == 0) {
                    right++;
                } else if (right == result.length - 1) {
                    left--;
                } else {
                    right++;
                    left--;
                }
                x++;
            }
            result[i] = x;
        }
        return result;
    }

    public int[] shortestToChar2(String S, char C) {
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            result[i] = -1;
        }
        // 将字符C的位置的数初始化为0
        for (int i = 0; i < result.length; i++) {
            if (S.charAt(i) == C) {
                result[i] = 0;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                continue;
            }
            int left = i, right = i;
            int x = 0;
            while (result[left] != 0 && result[right] != 0) {
                if (left == 0) {
                    right++;
                } else if (right == result.length - 1) {
                    left--;
                } else {
                    right++;
                    left--;
                }
                x++;
            }
            result[i] = x;
        }
        return result;
    }

    @Test
    public void test() {
        String s = "loveleetcode";
        char C = 'e';
        System.out.println(shortestToChar(s, C));
    }
}
