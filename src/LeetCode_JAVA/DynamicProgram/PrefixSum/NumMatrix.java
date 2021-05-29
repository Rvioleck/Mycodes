package LeetCode_JAVA.DynamicProgram.PrefixSum;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)
 */
public class NumMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        int row1 = 2, col1 = 1, row2 = 4, col2 = 3;
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(row1,col1,row2,col2);
        System.out.println(param_1);
    }

    int[][] prefix;

    /**
     * 构造前缀和矩阵
     * @param matrix 原m×n矩阵
     * prefix 为前缀和构成的(m+1)×(n+1)矩阵
     */
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 添加一行一列的元素并从1开始遍历可以简化越界问题
        prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                int num = matrix[i - 1][j - 1];
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + num;
            }
        }
    }

    /**
     * @param row1 返回矩阵的行左下标
     * @param col1 返回矩阵的列左下标
     * @param row2 返回矩阵的行右下标
     * @param col2 返回矩阵的列右下标
     * @return 返回矩阵中所有元素之和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] + prefix[row1][col1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1];
    }

}
