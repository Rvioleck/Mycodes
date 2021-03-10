package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.Scanner;

public class G_TakeOut_Java {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int[] level = new int[N + 1];    //存放优先级
        boolean[] judge = new boolean[N + 1];    //存放是否在缓存队列,初始值为false
        ArrayList<Integer>[] array = new ArrayList[T + 1];    //存放每个时刻对应的店铺
        for (int i = 0; i <= T; i++) {
            array[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int ts = sc.nextInt();
            int id = sc.nextInt();
            array[ts].add(id);
        }
        for (int i = 1; i <= T; i++) {    //枚举array
            for (int j = 1; j <= N; j++) {    //枚举店铺
                int flag = 0;
                Object k = j;
                while (array[i].contains(k)) {    //使用while是因为存在一个时刻一个店铺存在多个订单
                    flag = 1;
                    array[i].remove(k);
                    level[j] += 2;
                    if (level[j] > 5) {
                        judge[j] = true;
                        res++;
                    }
                }
                if (flag == 0) {    //此时刻无店铺j的订单
                    level[j] = level[j] == 0 ? 0 : level[j] - 1;
                    if (judge[j]) {    //原来在缓存队列
                        if (level[j] <= 3) {    //优先级下降
                            judge[j] = false;
                            res--;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

}
/*
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
 */