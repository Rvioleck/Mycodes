package LeetCode_JAVA.String;

import java.util.*;

public class IsAlienSorted {

    Map<Character, Integer> map = new HashMap<>();

    public int compareTo(String o1, String o2){
        int len1 = o1.length(), len2 = o2.length();
        int i;
        for (i = 0; i < len1 && i < len2; i++) {
            char ch1 = o1.charAt(i), ch2 = o2.charAt(i);
            int prior1 = map.get(ch1), prior2 = map.get(ch2);
            if (prior1 > prior2) {
                return 1;
            } else if (prior1 < prior2) {
                return -1;
            }
        }
        if (len1 == len2){
            return 0;
        }
        if (i == len2){
            return 1;
        } else if (i == len1){
            return -1;
        }
        return 0;
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1){
            return true;
        }
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (compareTo(words[i - 1], words[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAlienSorted().isAlienSorted(new String[]{
                "apple","app",
                "hello","leetcode",
                "word","world","row"
        }, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
