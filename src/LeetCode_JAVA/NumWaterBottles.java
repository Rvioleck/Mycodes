package LeetCode_JAVA;

public class NumWaterBottles {

    public static void main(String[] args) {
        int numBottles = 10, numExchange = 3;
        System.out.println(new NumWaterBottles().numWaterBottles(numBottles, numExchange));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        return dfs(numBottles, numExchange, 0);
    }

    public int dfs(int numBottles, int numExchange, int numEmptyBottles){
        if (numBottles == 0){
            return 0;
        }
        return numBottles + dfs((numBottles + numEmptyBottles) / numExchange, numExchange, (numBottles + numEmptyBottles) % numExchange);
    }

}
