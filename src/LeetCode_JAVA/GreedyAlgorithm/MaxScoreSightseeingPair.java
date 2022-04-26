package LeetCode_JAVA.GreedyAlgorithm;

public class MaxScoreSightseeingPair {

    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPair(values));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int left = 0, res = 0;
        for (int i = 0; i < values.length; ++i) {
            res = Math.max(res, left + values[i] - i);
            left = Math.max(left, values[i] + i);
        }
        return res;
    }

}
