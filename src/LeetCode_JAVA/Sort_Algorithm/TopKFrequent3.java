package LeetCode_JAVA.Sort_Algorithm;

import java.util.*;

public class TopKFrequent3 {

    // 自定义排序
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(count.keySet());
        candidates.sort((w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequent3().topKFrequent(new String[]{
                "i", "love", "love", "i", "leetCode", "one", "the"
        }, 2));
    }


}
