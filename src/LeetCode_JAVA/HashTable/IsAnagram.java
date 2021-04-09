package LeetCode_JAVA.HashTable;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new IsAnagram().isAnagram(s, t));
        System.out.println(new IsAnagram().isAnagram2(s, t));
        System.out.println(new IsAnagram().isAnagram3(s, t));
    }

    public boolean isAnagram3(String s, String t) {
        // 数组代替hashTable
        int[] ch = new int[26];
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen){
            return false;
        }
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            ch[c - 'a']++;
        }
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ch[c - 'a']--;
            if (ch[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int sLen = s.length(), tLen = t.length();
        for (int i = 0; i < sLen; i++) {
            char sCh = s.charAt(i);
            sMap.put(sCh, sMap.getOrDefault(sCh, 0) + 1);
        }
        for (int i = 0; i < tLen; i++) {
            char tCh = t.charAt(i);
            tMap.put(tCh, tMap.getOrDefault(tCh, 0) + 1);
        }
        return sMap.equals(tMap);
    }

    public boolean isAnagram2(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int len2 = t.length();
        for (int i = 0; i < len2; i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)){
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        return map.isEmpty();
    }

}
