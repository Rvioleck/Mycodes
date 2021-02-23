package Test_Pro;

public class HuiSquare {
    public int[][] huiSquare(int n) {
        int[][] res = new int[n][n];
        int minX = 0;
        int maxX = n - 1;
        int minY = 0;
        int maxY = n - 1;
        int num = 0;
        while (minX <= maxX) {
            for (int i = minY; i <= maxY; i++) {
                res[minX][i] = ++num;
            }
            minX++;
            for (int i = minX; i <= maxX; i++) {
                res[i][maxY] = ++num;
            }
            maxY--;
            for (int i = maxY; i >= minY; i--) {
                res[maxX][i] = ++num;
            }
            maxX--;
            for (int i = maxX; i >= minX; i--) {
                res[i][minY] = ++num;
            }
            minY++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        HuiSquare hs = new HuiSquare();
        int[][] res = hs.huiSquare(n);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " \t");
            }
            System.out.println();
        }
    }
}
