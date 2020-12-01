package Examine_Pro;

public class Paper27Java002 {
    //*********Found**********
    public static void main(String[] args){ // void
//*********Found**********
        int[][] aMatrix = {{1,1,1,1},{2,2,2},{3,3},{4}}; // int[][]
        int i = 0; //循环变量
        int j = 0; //循环变量
        //打印二维数组
//*********Found**********
        for(i = 0; i < aMatrix.length; i++){ // aMatrix
//*********Found**********
            for (j = 0; j < aMatrix[i].length; j++) { // aMatrix[i]
                System.out.print(aMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
