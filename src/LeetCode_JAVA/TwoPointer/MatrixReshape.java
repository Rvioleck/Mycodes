package LeetCode_JAVA.TwoPointer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class MatrixReshape {

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(new MatrixReshape().matrixReshape(mat, r, c)));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        int[][] reshape = new int[r][c];
        int desM = 0;
        int desN = 0;
        for (int[] row : mat){
            for (int d : row){
                if (desN < c){
                    reshape[desM][desN++] = d;
                }
                if (desN == c){
                    desN = 0;
                    desM++;
                }
            }
        }
        return reshape;
    }
}
