package Examine_Pro;

import java.util.Random;

public class Paper16Java002 {
    //*********Found**********
    public static void main(String args[]){ //static
        Random random = new Random();
        //*********Found**********
        float x = random.nextFloat();//产生0.0与1.0之间的一个浮点数  // random
        //*********Found**********
        int n = Math.round(21*x);  //构造20以内的一个整数 // round
        long f = 1 ;  //保存阶乘的结果
        int k = 1 ;  //循环变量
        do {
            //*********Found**********
            f*= k++; // k++
        }while(k<=n);
        System.out.println(n+"!= "+f);
    }
}
