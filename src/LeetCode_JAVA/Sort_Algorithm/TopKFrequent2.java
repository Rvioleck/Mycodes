package LeetCode_JAVA.Sort_Algorithm;

import java.util.*;

public class TopKFrequent2 {

    Map<String, Integer> map = new HashMap<>();

    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) ->
                (map.get(x).equals(map.get(y)) ? y.compareTo(x) : map.get(x) - map.get(y))
        );
        for (String word : map.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(0, heap.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequent2().topKFrequent(new String[]
                {"i", "love", "leetcode", "i", "love", "coding"}, 1));
    }
}
