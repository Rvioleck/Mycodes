package Examine_Pro;

public class Paper2Java002 {
    public static void main(String[] args) {
        //*********Found********
        int[][] aMatrix = new int[6][];

        int i = 0;
        int j = 0;
        int k = 0;

        //*********Found********
        for ( i = 0; i < aMatrix.length; i++) {

            aMatrix[i] = new int[j + 1];  //创建数组。

            //给每个数组元素赋值并在一行中打印输出。
            for (k = 0; k < aMatrix[i].length; k++) {
                aMatrix[i][k] = k + 1;
                System.out.print(aMatrix[i][k] + " ");
            }
            j++;
            System.out.println(); //换行。
        }
    }
}
