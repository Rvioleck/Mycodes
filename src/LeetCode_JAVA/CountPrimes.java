package LeetCode_JAVA;

import java.util.*;
public class CountPrimes {
    public int countPrimes(int n){
        int count = 2;
        if ( n == 0 || n == 1 || n == 2 )
            return 0;
        if ( n == 3)
            return 1;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j <= Math.sqrt(i) + 1; j++) {
                if (i % j == 0)
                    break;
                if (j == (int)Math.sqrt(i))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        int n = 10;
        System.out.println(cp.countPrimes(n));
    }
}
