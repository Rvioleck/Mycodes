package LeetCode_JAVA.String;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char ch1 = s1.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            char ch2 = s2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }
        int index = len1;
        while (index < len2) {
            if (map1.equals(map2)) {
                return true;
            }
            char before = s2.charAt(index - len1);
            char after = s2.charAt(index);
            map2.put(before, map2.get(before) - 1);
            if (map2.get(before) == 0) {
                map2.remove(before);
            }
            map2.put(after, map2.getOrDefault(after, 0) + 1);
            index++;
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("adc", "dcda"));
    }
}
