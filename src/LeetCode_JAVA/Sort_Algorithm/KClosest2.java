package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest2 {

    public int[][] kClosest(int[][] points, int K) {
        // 堆排序(优先队列实现)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> (
                (int)(Math.pow(y[0], 2) + Math.pow(y[1], 2) - Math.pow(x[0], 2) - Math.pow(x[1], 2))
                ));
        for (int[] point:
             points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K){
                maxHeap.poll();
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new KClosest2().kClosest(new int[][]{
                {1, 2},
                {2, 0},
                {-2, 2},
                {3, 1},
                {4, 0},
                {1, -1}
        }, 3);
        for (int[] one:
                res) {
            System.out.println(Arrays.toString(one));
        }
    }

}
