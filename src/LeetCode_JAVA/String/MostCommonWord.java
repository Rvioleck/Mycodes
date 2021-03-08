package LeetCode_JAVA.String;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[!?',;. ]");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        map.remove("");
        for (String ban : banned) {
            map.remove(ban);
        }
        int max = 0;
        String res = "";
        for (Map.Entry elem : map.entrySet()) {
            String word = (String) elem.getKey();
            int count = (int) elem.getValue();
            if (count > max){
                max = count;
                res = word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord(
                "Bob. hIt, baLl",
                new String[]{"bob", "hit"}));
    }

}
