package Lanqiao;

import java.util.Scanner;

public class question5 {

    public int minK(int length, int k, int[] a){
        bubbleSort(a);
        int minX = 1;
        for (int i = 0; i < length - 1; i++) {
            if (a[i+1] != a[i])
                minX++;
            if (minX == k){
                return a[i+1];
            }
        }
        return -1;
    }

    public void bubbleSort( int b[] ){
        for ( int pass = 1; pass < b.length; pass++ )
            for ( int i = 0; i < b.length - 1; i++ )
                if ( b[ i ] > b[ i + 1 ] ) {
                    int temp = b[i];
                    b[i] = b[i+1];
                    b[i+1] = temp;
                }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] a = new int[length];
        int k = sc.nextInt();
        int i = 0;
        while (i != length){
            a[i] = sc.nextInt();
            i++;
        }
        question5 obj = new question5();
        String result = "NO RESULT";
        int mink = obj.minK(length, k, a);
        if (mink != -1)
            result = mink+"";
        System.out.println(result);
    }
}
