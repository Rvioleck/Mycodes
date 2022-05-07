package LeetCode_JAVA;

import Lanqiao.Practices.I;

import java.util.ArrayList;
import java.util.List;

public class Zigzag {

    public List<Integer> zigzag(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int a = 0, b = 0, c = 0, d = 0;
        boolean rev = false;
        while (a >= c && b <= d){
            printSlash(matrix, a, b, c, d, res, rev);
            rev = !rev;
            b = a == m - 1 ? b + 1 : b;
            a = a < m - 1 ? a + 1 : a;
            c = d == n - 1 ? c + 1 : c;
            d = d < n - 1 ? d + 1 : d;
        }
        return res;
    }

    public void printSlash(int[][] matrix, int a, int b, int c, int d, List<Integer> res, boolean reverse){
        if (a == c && b == d){
            res.add(matrix[a][b]);
            return;
        }
        if (reverse){
            while (a >= c && b <= d){
                res.add(matrix[a--][b++]);
            }
        } else {
            while (a >= c && b <= d){
                res.add(matrix[c++][d--]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Zigzag().zigzag(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }
}
