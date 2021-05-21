package LeetCode_JAVA.TwoPointer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 */
public class Merge {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{2,5,6};
        new Merge().merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; --k){
            if (i >= 0 && j >= 0 ){
                if (A[i] > B[j]){
                    A[k] = A[i--];
                } else {
                    A[k] = B[j--];
                }
            } else if (i >= 0){
                A[k] = A[i--];
            } else {
                A[k] = B[j--];
            }
        }
    }
}
