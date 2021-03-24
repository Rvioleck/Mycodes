package TrainStation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public long getMaxDistance(long[] city, int k){
        Arrays.sort(city);
        long[] distance = new long[city.length - 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = city[i + 1] - city[i];
        }
        int len = distance.length;
        Arrays.sort(distance);
        if (len == 1){
            return distance[len - 1] / (k+1);
        }
        while(k > 0){
            int num = 1; // 记录两点之间车站个数
            long afterDistance = distance[len - 1] / (num+1);
            while (afterDistance >= distance[len - 2] && num < k){
                num++;
                afterDistance = distance[len - 1] / (num+1);
            }
            distance[len - 1] = afterDistance;
            k -= num;
            Arrays.sort(distance);
        }
        return distance[len - 1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        int N = sc.nextInt();
        int k = sc.nextInt();
        long[] city = new long[N];
        for (int i = 0; i < N; i++) {
            city[i] = sc.nextLong();
        }
        System.out.println(obj.getMaxDistance(city, k));
    }
}
