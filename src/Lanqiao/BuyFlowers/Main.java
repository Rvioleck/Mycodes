package BuyFlowers;

import java.util.Scanner;

public class Main {
    public boolean isOk(int T, int[] k){
        for (int i = 1; i < k.length; i++) {
            if (T >= k[i] && T % k[i] == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] k = new int[]{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767};
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        int n = sc.nextInt();
        int T;
        while(n-- != 0){
            T = sc.nextInt();
            if (obj.isOk(T, k)){
                System.out.println("YE5");
            }else {
                System.out.println("N0");
            }
        }
    }
}
