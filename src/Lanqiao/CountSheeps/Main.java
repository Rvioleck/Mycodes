package CountSheeps;

import java.util.Scanner;

public class Main {
    public long a(int i, int j){
        if (i == 1 && j == 0)
            return 2;
        if (i == 0 && j <= 3 && j >=0)
            return 1;
        if (i >= 2 && i <= 1000000000 && j == 0)
            return i+2;
        if (i >= 1 && i <= 1000000000 && j >= 1 && j <= 1000000000)
            return a((int) (a(i-1, j)%998244353), j-1);
        return 0;
    }


    public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, j;
        while(n-- != 0){
            i = sc.nextInt();
            j = sc.nextInt();
            System.out.println(obj.a(i, j) % 998244353);
        }
    }

}
