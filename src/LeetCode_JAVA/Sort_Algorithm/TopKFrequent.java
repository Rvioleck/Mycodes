package LeetCode_JAVA.Sort_Algorithm;

import java.util.*;

public class TopKFrequent {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小根堆中数据元素int[]存储的第一个元素为数组元素值，第二个元素为该数组元素的频度
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((Comparator.comparingInt(x -> x[1])));
        for (Map.Entry<Integer, Integer> elem :
                map.entrySet()) {
            int num = elem.getKey(), frequency = elem.getValue();
            if (minHeap.size() == k) {
                if (minHeap.element()[1] < frequency) {
                    minHeap.poll();
                    minHeap.offer(new int[]{num, frequency});
                }
            } else {
                minHeap.offer(new int[]{num, frequency});
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int[] elem :
                minHeap) {
            res[i++] = elem[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new TopKFrequent().topKFrequent(new int[]{1, 2, 2, 3, 3, 1, 0, 4, 0}, 2);
        System.out.println(Arrays.toString(res));
    }

}
