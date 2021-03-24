package AdvancedFanFan;

import java.util.Scanner;

public class Main {
    public long accumulation(int len){
        long count = 0;
        for (int i = 1; i <= len; i++) {
            count += i;
        }
        return count;
    }

    public long nice(int n, int a[]){
        long count = 0;
        int len = 1;
        for (int i = 0; i < n - 1; i++) {
            if (a[i + 1] >= a[i]){
                len++;
            }else{
                count += accumulation(len);
                len = 1;
            }
        }
        count += accumulation(len);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 10
        //2 3 7 6 9 4 2 3 0 1
        int n = sc.nextInt();
        int i = 0;
        int[] a = new int[n];
        while (i < n){
            a[i++] = sc.nextInt();
        }
        AdvancedFanFan.Main obj = new AdvancedFanFan.Main();
        System.out.println(obj.nice(n, a));
        //</editor-fold>
    }
}
