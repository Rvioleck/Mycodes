package Examine_Pro;

public class Paper18Java002 {

    public static void main(String args[]) {
        int [][]a = {{2, 3, 4}, {4, 6, 5}};
        int [][]b = {{1, 5, 2, 8}, {5, 9, 10, -3}, {2, 7, -5, -18}};
        //*********Found**********
        int [][]c = new int[2][4]; // new int[2][4]
        for (int i = 0; i < 2; i++) {
            //*********Found**********
            for (int j = 0; j < 4; j++) { // 4
                //*********Found**********
                c[i][j] = 0; // c[i][j] = 0
                for (int k = 0; k < 3; k++)
                    //*********Found**********
                    c[i][j] += a[i][k]*b[k][j]; // a[i][k]*b[k][j]
                System.out.print(c[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
