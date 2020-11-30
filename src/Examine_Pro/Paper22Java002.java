package Examine_Pro;

import java.io.*;

public class Paper22Java002 {
    public static void main(String[] args) {

        int[] anArray  = new int[10];   // 声明并创建包含10个元素的整型数组。
        int i = 0;
        int total=0;

        try{
            // 从data.dat中读出10个整数，放在整型数组中。

            //*********Found********
            DataInputStream in = new DataInputStream(new FileInputStream("data.dat")); // FileInputStream
            while(in.available() != 0){
                anArray[i++] = in.readInt();
            }
            in.close();

            //将整型数组中的10个整数相加，并将这些数及其和显示输出。
            for ( i = 0; i < anArray.length; i++){

                //*********Found********
                total = total+anArray[i];
                if (i<anArray.length-1){
                    System.out.print(anArray[i]);
                    System.out.print('+');
                }
                else{
                    System.out.print(anArray[i]);
                }
            }
            System.out.println(" =  "+total);
        }catch(IOException e1){}
    }
}
