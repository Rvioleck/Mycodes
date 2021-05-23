package LeetCode_JAVA;

import org.junit.Test;

public class AddBinary {
    public String addBinary(String a, String b) {
        int anum = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1')
                anum += Math.pow(2, a.length() - i - 1);
        }
        int bnum = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '1')
                bnum += Math.pow(2, b.length() - i - 1);
        }
        return Integer.toBinaryString(anum + bnum);
    }

    @Test
    public void test() {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
