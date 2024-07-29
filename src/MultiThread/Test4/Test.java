package MultiThread.Test4;

import java.util.Random;

public class Test {


    public static void main(String[] args) {

        Thread[] t = new Thread[5];
        for (int i = 0; i < 5; i++) {
            t[i] = new Thread(() -> {
                synchronized (RedBag.class) {
                    if (RedBag.leftCount > 1) {
                        int money = (int)(new Random().nextFloat() * RedBag.leftMoney);
                        System.out.println(Thread.currentThread().getName() + "抢到了" + money + "元");
                        RedBag.leftMoney -= money;
                        RedBag.leftCount--;
                    } else if (RedBag.leftCount == 1) {
                        System.out.println(Thread.currentThread().getName() + "抢到了" + RedBag.leftMoney + "元");
                        RedBag.leftMoney = 0;
                        RedBag.leftCount--;
                    } else {
                        System.out.println(Thread.currentThread().getName() + "没有抢到红包");
                    }
                }
            });
        }
        for (int i = 0; i < 5; i++) {
            t[i].start();
        }

    }

}
