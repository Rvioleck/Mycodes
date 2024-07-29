package LeetCode_JAVA;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] d = new int[1002];  // nums的差分数组
        for (int[] trip : trips) {
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];
            d[from] += passenger;
            d[to] -= passenger;
        }
        int numi = 0;
        for (int i = 0; i < 1001; ++i) {
            numi += d[i];
            if (numi > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        System.out.println(new CarPooling().carPooling(trips, 3));
    }
}
