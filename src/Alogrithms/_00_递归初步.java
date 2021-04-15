package Alogrithms;

import java.util.Scanner;

public class _00_递归初步 {

    /**
     * 求n的阶乘
     * ①找重复：n*(n-1)!，求n-1的阶乘是原问题的重复——子问题
     * ②找变化：变化的量作为参数
     * ③找边界：出口
     * @param n 整型值
     * @return n!
     */
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void printFactorial(int i, int j){
        if (i == j){
            System.out.print(j + " = ");
            return;
        }
        System.out.print(i + " * ");
        printFactorial(i + 1, j);
    }

    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();
        printFactorial(1, n);
        System.out.println(factorial(n));
    }

}
