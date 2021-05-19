package LeetCode_JAVA.Sort_Algorithm;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 */
public class KthLargestValue {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {10,9,5},
                {2,0,4},
                {1,0,9},
                {3,4,8}
        };
        int k = 10;
        System.out.println(new KthLargestValue().kthLargestValue(matrix, k));
    }

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        minHeap.add(dp[0][0]);
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if (minHeap.size() < k) {
                    minHeap.add(dp[i][j]);
                } else {
                    if (minHeap.element() < dp[i][j]) {
                        minHeap.remove();
                        minHeap.add(dp[i][j]);
                    }
                }
            }
        }
        return minHeap.remove();
    }

}
