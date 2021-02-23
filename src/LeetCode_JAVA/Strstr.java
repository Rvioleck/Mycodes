package LeetCode_JAVA;

import org.junit.Test;

public class Strstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i < len1 - len2 + 1; i++) {
            if (haystack.substring(i, i + len2).equals(needle))
                return i;
        }
        return -1;
    }


    @Test
    public void test() {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }
}
