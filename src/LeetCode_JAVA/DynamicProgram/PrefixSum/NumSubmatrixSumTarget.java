package LeetCode_JAVA.DynamicProgram.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 */
public class NumSubmatrixSumTarget {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,0},
                {1,1,1},
                {0,1,0}
        };
        int target = 0;
        System.out.println(new NumSubmatrixSumTarget().numSubmatrixSumTarget(matrix, target));
        System.out.println(new NumSubmatrixSumTarget().numSubmatrixSumTarget1(matrix, target));
        System.out.println(new NumSubmatrixSumTarget().numSubmatrixSumTarget2(matrix, target));
    }

    /**
     * @param matrix 原m×n矩阵
     * @param target 目标值target
     * @return 子矩阵和为target的个数
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                for (int k = i; k <= m; ++k) {
                    for (int l = j; l <= n; ++l) {
                        if (prefix[k][l] - prefix[k][j - 1] - prefix[i - 1][l] + prefix[i - 1][j - 1] == target){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int numSubmatrixSumTarget1(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int bottom = 1; bottom <= m; ++bottom){
            for (int top = bottom; top <= m; ++top){
                int rSum;
                Map<Integer, Integer> map = new HashMap<>();
                for (int right = 1; right <= n; ++right){
                    rSum = prefix[top][right] - prefix[bottom - 1][right];
                    if (rSum == target) count++;
                    if (map.containsKey(rSum - target)){
                        count += map.get(rSum - target);
                    }
                    map.put(rSum, map.getOrDefault(rSum, 0) + 1);
                }
            }
        }
        return count;
    }

    public int numSubmatrixSumTarget2(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int count = 0;
        boolean isRight = m > n;
        for (int i = 1; i <= (isRight ? n : m); ++i){
            for (int j = i; j <= (isRight ? n : m); ++j){
                int rSum;
                Map<Integer, Integer> map = new HashMap<>();
                for (int right = 1; right <= (isRight ? m : n); ++right){
                    rSum = isRight ? prefix[right][j] - prefix[right][i - 1] : prefix[j][right] - prefix[i - 1][right];
                    if (rSum == target) count++;
                    if (map.containsKey(rSum - target)){
                        count += map.get(rSum - target);
                    }
                    map.put(rSum, map.getOrDefault(rSum, 0) + 1);
                }
            }
        }
        return count;
    }

}
