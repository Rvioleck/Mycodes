package LeetCode_JAVA.Sort_Algorithm;

import java.util.PriorityQueue;

public class FindKthLargest2 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.add(nums[i]);
            } else {
                if (minHeap.element() < nums[i]) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.remove();
    }


}
