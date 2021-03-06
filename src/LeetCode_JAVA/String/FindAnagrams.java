package LeetCode_JAVA.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> mapPattern = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char ch = p.charAt(i);
            mapPattern.put(ch, mapPattern.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> mapString = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char ch = s.charAt(i);
            mapString.put(ch, mapString.getOrDefault(ch, 0) + 1);
        }
        int index = pLen;
        while (index < sLen){
            if (mapPattern.equals(mapString)){
                res.add(index - pLen);
            }
            char chBefore = s.charAt(index - pLen);
            char chAfter = s.charAt(index);
            if (chBefore != chAfter){
                mapString.put(chBefore, mapString.get(chBefore) - 1);
                if (mapString.get(chBefore) == 0){
                    mapString.remove(chBefore);
                }
                mapString.put(chAfter, mapString.getOrDefault(chAfter, 0) + 1);
            }
            index++;
        }
        if (mapPattern.equals(mapString)){
            res.add(index - pLen);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("cbaebabacd", "acd"));
    }

}
