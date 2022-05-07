package LeetCode_JAVA;

import java.util.Arrays;

public class Rotate {


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int a = 0, b = 0, c = n - 1, d = n - 1;
             a < c && b < d; a++, b++, c--, d--){
            rotateEdge(matrix, a, b, c, d);
        }
    }

    public void rotateEdge(int[][] matrix, int a, int b, int c, int d){
        for (int k = 0; k < d - b; ++k){
            int temp = matrix[a][b + k];
            matrix[a][b + k] = matrix[c - k][b];
            matrix[c - k][b] = matrix[c][d - k];
            matrix[c][d - k] = matrix[a + k][d];
            matrix[a + k][d] = temp;
        }
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Rotate().rotate(matrix);
        for (int[] line: matrix){
            System.out.println(Arrays.toString(line));
        }
    }

}

