package LeetCode_JAVA.DynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new MinimumTotal().minimumTotal(triangle));
        System.out.println(new MinimumTotal().minimumTotal_optimise(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n, min = Integer.MAX_VALUE;
        int[][] dp = new int[m][];
        for (int i = 0; i < m; ++i) {
            n = triangle.get(i).size();
            dp[i] = new int[n];
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = row.get(0);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + row.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + row.get(j);
                }
                if (i == m - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }

    public int minimumTotal_optimise(List<List<Integer>> triangle) {
        int m = triangle.size(), n, min = Integer.MAX_VALUE;
        int[][] dp = new int[2][];
        for (int i = 0; i < m; ++i) {
            n = triangle.get(i).size();
            dp[1] = new int[n];
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    dp[1][j] = row.get(0);
                } else if (j == 0) {
                    dp[1][j] = dp[0][j] + row.get(j);
                } else if (j == i) {
                    dp[1][j] = dp[0][j - 1] + row.get(j);
                } else {
                    dp[1][j] = Math.min(dp[0][j], dp[0][j - 1]) + row.get(j);
                }
                if (i == m - 1) {
                    min = Math.min(min, dp[1][j]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], n);
        }
        return min;
    }

}
