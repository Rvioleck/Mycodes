package LeetCode_JAVA.String;

import java.util.HashMap;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) {
            return false;
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < lenS; i++) {
            char ch = s.charAt(i);
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < lenT; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        return mapS.equals(mapT);
    }

    public boolean isAnagram2(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) {
            return false;
        }
        int res = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < lenS; i++) {
            char ch = s.charAt(i);
            sum1 += ch;
            res ^= ch;
        }
        for (int i = 0; i < lenT; i++) {
            char ch = t.charAt(i);
            sum2 += ch;
            res ^= ch;
        }
        return sum1 == sum2 && res == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
    }

}
