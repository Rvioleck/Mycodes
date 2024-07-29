package LeetCode_JAVA;

public class SpiralMatrixIII {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int count = 0;
        int stride = 1;
        int numTurn = 1;
        int direction = 0;  // 0 东, 1 南, 2 西, 3 北
        int r = rStart, c = cStart;
        while (count != rows * cols) {
            if (r < rows && r >= 0 && c < cols && c >= 0) {
                res[count] = new int[]{r, c};
                count++;
            }
            switch (direction) {
                case 0:
                    c += 1; break;
                case 1:
                    r += 1;
                    break;
                case 2:
                    c -= 1; break;
                case 3:
                    r -= 1;
                    break;
            }
            numTurn -= 1;
            if (numTurn == 0) {
                direction = (direction + 1) % 4;
                numTurn = stride;
                if (direction % 2 == 1) {
                    stride++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new SpiralMatrixIII().spiralMatrixIII(5, 6, 1, 4);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
}
