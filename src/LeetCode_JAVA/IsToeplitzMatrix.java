package LeetCode_JAVA;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        };
        System.out.println(new IsToeplitzMatrix().isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (!hasSameNums(matrix, i, 0)){
                return false;
            }
        }
        for (int j = 0; j < n; j++){
            if (!hasSameNums(matrix, 0, j)){
                return false;
            }
        }
        return true;
    }

    public boolean hasSameNums(int[][] matrix, int x, int y){
        int num = matrix[x][y];
        while (++x < matrix.length && ++y < matrix[0].length){
            if (num != matrix[x][y]){
                return false;
            }
        }
        return true;
    }
}
