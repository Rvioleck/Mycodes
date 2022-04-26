package LeetCode_JAVA.GreedyAlgorithm;

import org.junit.Test;

public class RomanToInt {
    public int roman(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = roman(chars[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (roman(chars[i]) < roman(chars[i + 1])) {
                result -= roman(chars[i]);
            } else
                result += roman(chars[i]);
        }
        return result;
    }

    @Test
    public void test() {
        String s = "IX";
        System.out.println(romanToInt(s));
    }
}
