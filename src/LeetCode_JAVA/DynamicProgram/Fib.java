package LeetCode_JAVA.DynamicProgram;

public class Fib {
    public int fib(int n) {
        // O(n)
        int f0 = 0, f1 = 1, result = 0;
        if (n == 0)
            return f0;
        if (n == 1)
            return f1;
        for (int i = 1; i < n; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }

    public int fib2(int n){
        // 矩阵快速幂O(logn)
        if (n == 0) return 0;
        if (n == 1 || n == 2){
            return 1;
        }
        int[][] base = new int[][]{
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    private int[][] matrixPower(int[][] base, int n) {
        int[][] res = new int[base.length][base[0].length];
        for (int i = 0; i < res.length; ++i){
            res[i][i] = 1;
        }
        int[][] temp = base;
        for (; n != 0; n >>>= 1){
            if ((n & 1) == 1){
                res = matrixMul(res, temp);
            }
            temp = matrixMul(temp, temp);
        }
        return res;
    }

    private int[][] matrixMul(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int l = a[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                for (int k = 0; k < l; ++k){
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(23));
        System.out.println(new Fib().fib2(23));
    }

}
