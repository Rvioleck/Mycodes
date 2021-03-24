package Lanqiao.Practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G {
    public void reverse(List<Integer> a){
        int len = a.size();
        for (int i = 0; i < len; i++) {
            if (a.get(i).equals(0))
                a.add(1);
            else
                a.add(0);
        }
    }

    public void funG(long a[]){
        List<Integer> pass = new ArrayList<Integer>();
        pass.add(0);
        for (int i = 0; i < a.length; i++) {
            while (a[i] >= pass.size()){
                reverse(pass);
            }
            System.out.println(pass.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] a = new long[t];
        int i = -1;
        while (++i!=t){
            a[i] = sc.nextLong();
        }
        G obj = new G();
        obj.funG(a);
    }
}
