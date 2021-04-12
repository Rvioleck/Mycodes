package LeetCode_JAVA.String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> minHeap = new PriorityQueue<>((x, y) -> (
                frequency.get(y) - frequency.get(x)
        ));
        for (char ch :
                frequency.keySet()) {
            minHeap.offer(ch);
        }
        StringBuilder res = new StringBuilder();
        while (!minHeap.isEmpty()) {
            char ch = minHeap.poll();
            int count = frequency.get(ch);
            while (count-- != 0) {
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FrequencySort().frequencySort("tree"));
    }

}
