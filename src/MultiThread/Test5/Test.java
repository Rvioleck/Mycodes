package MultiThread.Test5;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new PrizePool();
        Thread t2 = new PrizePool();
        t1.start();
        t2.start();
    }
}
