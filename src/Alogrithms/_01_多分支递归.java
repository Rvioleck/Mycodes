package Alogrithms;

public class _01_多分支递归 {

    public static int fib(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int gcd(int m, int n){
        if (n == 0){
            return m;
        }
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(gcd(21,14));
    }

}
