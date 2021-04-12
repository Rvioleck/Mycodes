package LeetCode_JAVA.String;

import java.util.HashMap;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        boolean tag = false;
        for (int count : map.values()) {
            if (count % 2 == 0) {
                sum += count;
            } else {
                sum += count - 1;
                tag = true;
            }
        }
        if (tag) {
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }

}
