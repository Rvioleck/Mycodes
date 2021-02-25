package LeetCode_JAVA.Sort_Algorithm;

import java.util.PriorityQueue;

public class GetLeaseNumbers2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < arr.length; i++) {
            if (i < k){
                maxHeap.add(arr[i]);
            } else {
                if (maxHeap.element() > arr[i]){
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (int num:
             maxHeap) {
            res[index++] = num;
        }
        return res;
    }

}
