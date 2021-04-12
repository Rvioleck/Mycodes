package LeetCode_JAVA.String;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWord {

    public static void main(String[] args) {
        String[] words = new String[]{
//                "a", "banana", "app", "appl", "ap", "apply", "apple",
//                "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"
                "rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"
//                "vsw","vs","zwu","vsx","nc","o","vswus","orv","imf","i","v","zw","vs"

        };
        String s = new LongestWord().longestWord(words);
        System.out.println(s);
    }

    public String longestWord(String[] words) {
        HashSet<String> wordset = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        for (String word : words) {
            boolean good = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }
            if (good) return word;
        }
        return "";
    }
}
