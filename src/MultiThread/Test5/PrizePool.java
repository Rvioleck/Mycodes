package MultiThread.Test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrizePool extends Thread {

    static ArrayList<Integer> prizes = new ArrayList<>(Arrays.asList(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));

    @Override
    public void run() {
        while (true) {
            synchronized (PrizePool.class) {
                if (!prizes.isEmpty()) {
                    int index = (int) (new Random().nextDouble() * prizes.size());
                    int prize = prizes.remove(index);
                    System.out.println(getName() + "中奖了，奖金是：" + prize);
                } else {
                    break;
                }
            }
        }
    }
}
