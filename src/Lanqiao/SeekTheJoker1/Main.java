package SeekTheJoker1;

import java.util.Scanner;

public class Main {
    public boolean fangNaiWin(int n, int k){
        if (n == 1){
            return false;
        }
        if (k >= n-1){
            return true;
        }
        if (n % (k+1) == 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        int T = sc.nextInt();
        int n, k;
        while (T-- != 0){
            n = sc.nextInt();
            k = sc.nextInt();
            if (obj.fangNaiWin(n, k)){
                System.out.println("yo xi no forever!");
            }else{
                System.out.println("ma la se mi no.1!");
            }
        }
    }
}
