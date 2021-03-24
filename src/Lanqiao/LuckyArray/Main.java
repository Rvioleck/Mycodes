package LuckyArray;

import java.util.Scanner;

public class Main {
    public boolean isLucky(int a[], int i, int j, int k){
        long sum = 0;
        for (int l = i; l <= j; l++) {
            sum += a[l];
        }
        if (sum >= k && sum % k == 0){
            return true;
        }
        return false;
    }

    public int maxSubArray(int a[], int n, int k){
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        if (sum < k)
            return -1;
        int i = 0, j = n - 1;
        while(i <= j){
            if (isLucky(a, i, j, k)){
                return j - i + 1;
            }
            if (isLucky(a, i+1, j, k)){
                return j - i;
            }
            if (isLucky(a, i, j - 1, k)){
                return j - i;
            }
            i++;
            j--;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        int N = sc.nextInt();
        int n, k;
        while (N-- != 0){
            n = sc.nextInt();
            int[] a = new int[n];
            k = sc.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(obj.maxSubArray(a, n, k));
        }
    }

}
