package LeetCode_JAVA;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] d = new int[n + 2];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int forward = direction == 0 ? 1 : -1;
            d[start] += forward;
            d[end + 1] -= forward;
        }
        StringBuilder newString = new StringBuilder(s);
        int dSum = 0;
        for (int i = 0; i < n; ++i) {
            dSum += d[i];
            int oldChar = newString.charAt(i) - 'a' - (dSum % 26);
            char newChar = (char) (((oldChar + 26) % 26) + 97);
            newString.setCharAt(i, newChar);
        }
        return new String(newString);
    }

    public static void main(String[] args) {
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(new ShiftingLetters().shiftingLetters("abc", shifts));
    }


}
