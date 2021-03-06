package LeetCode_JAVA.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        List<String> text = Arrays.asList(s.split(" "));
        int len = pattern.length();
        if (len != text.size()){
            return false;
        }
        Map<Character, String> match = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = pattern.charAt(i);
            if (!match.containsKey(ch)){
                String wordIn = text.get(i);
                if (match.containsValue(wordIn)){
                    return false;
                } else {
                    match.put(ch, wordIn);
                }
            } else {
                if (!match.get(ch).equals(text.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
    }

}
