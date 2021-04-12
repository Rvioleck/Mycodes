package LeetCode_JAVA;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int digit = 0;
        int rowNum = n - 1;
        int loop = n / 2;
        int i, j, startX = 0, startY = 0;
        while (loop-- != 0) {
            for (j = startY; j < startY + rowNum; j++) {
                matrix[startX][j] = ++digit;
            }
            for (i = startX; i < startX + rowNum; i++) {
                matrix[i][startY + rowNum] = ++digit;
            }
            for (j = startY + rowNum; j > startY; j--) {
                matrix[startX + rowNum][j] = ++digit;
            }
            for (i = startX + rowNum; i > startX; i--) {
                matrix[i][startY] = ++digit;
            }
            rowNum -= 2;
            startX++;
            startY++;
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = n * n;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new GenerateMatrix2().generateMatrix(n);
        for (int[] row : matrix) {
            for (int w : row) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

}
