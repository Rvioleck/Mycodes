import java.util.Scanner;

public class I {

    public double funI(double x, double y, int k){
        if (k == 1)
            return x;
        if (k == 2)
            return y;
        k -= 2;
        double res = 0;
        while(k-- != 0){
            res = (1+y)/x;
            x = y;
            y = res;
        }
        return y;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k =sc.nextInt();
        I obj = new I();
        System.out.println(obj.funI(a,b,k));
    }
}
