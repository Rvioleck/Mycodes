package LeetCode_JAVA;

public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] d = new int[n + 2];
        for (int[] booking: bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            d[first - 1] += seats;
            d[last] -= seats;
        }
        int[] answer = new int[n];
        answer[0] = d[0];
        for (int i = 1; i < n; ++i) {
            answer[i] = answer[i - 1] + d[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        System.out.println(new CorpFlightBookings().corpFlightBookings(bookings, n));
    }
}
