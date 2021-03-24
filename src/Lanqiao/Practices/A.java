package Lanqiao.Practices;

import java.util.Scanner;

public class A {
    public int max(int a[], int i, int j){
        int res = 0;
        for (int k = i; k <= j; k++) {
            if (a[k] > res)
                res = a[k];
        }
        return res;
    }

    public int f(int i, int j){
        int res = i&j;
        if (res == i || res == j){
            return 1;
        }
        return 0;
    }

    public int funA(int a[]){
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i+1; j < a.length; j++) {
                sum += max(a, i, j) * f(i, j);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int i = -1;
        while (++i != n){
            a[i] = sc.nextInt();
        }
        A obj = new A();
        int result = obj.funA(a);
        System.out.println(result);
    }
}
