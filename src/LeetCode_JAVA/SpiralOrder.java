package LeetCode_JAVA;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int a = 0, b = 0, c = m - 1, d = n - 1;
             a <= c && b <= d; a++, b++, c--, d--) {
            printEdge(matrix, a, b, c, d, res);
        }
        return res;
    }

    public void printEdge(int[][] matrix, int a, int b, int c, int d, List<Integer> res) {
        if (a == c) {
            for (int i = b; i <= d; ++i) {
                res.add(matrix[a][i]);
            }
            return;
        }
        if (b == d) {
            for (int j = a; j <= c; ++j) {
                res.add(matrix[j][b]);
            }
            return;
        }
        for (int i = b; i < d; ++i) {
            res.add(matrix[a][i]);
        }
        for (int j = a; j < c; ++j) {
            res.add(matrix[j][d]);
        }
        for (int i = d; i > b; --i) {
            res.add(matrix[c][i]);
        }
        for (int j = c; j > a; --j) {
            res.add(matrix[j][b]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }

}
