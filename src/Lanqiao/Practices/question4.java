package Lanqiao.Practices;

import java.util.Scanner;

public class question4 {

    public int completeTree(int length, int[] a){
        int max = 0, maxFloor = 1, floor = 1, sum = 0, i = 0;
        while (length != 0 ){
            int elemNum = (int)Math.pow(2, floor - 1);
            length -= elemNum;
            while (elemNum-- != 0){
                sum += a[i++];
            }
            if (sum > max){
                maxFloor = floor;
                max = sum;
                sum = 0;
            }
            floor++;
        }
        return maxFloor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int i = 0;
        while (i != n){
            a[i++] = scanner.nextInt();
        }
        question4 obj = new question4();
        System.out.println(obj.completeTree(n, a));
    }
}
