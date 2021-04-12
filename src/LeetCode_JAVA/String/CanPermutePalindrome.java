package LeetCode_JAVA.String;

import java.util.HashMap;

public class CanPermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        for (int count : map.values()) {
            if (count % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanPermutePalindrome().canPermutePalindrome("tactcoa"));
    }

}
