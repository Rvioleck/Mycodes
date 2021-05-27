package LeetCode_JAVA.Greedy_Algorithm;

public class IntToRoman {

    public static void main(String[] args) {
        int num = 1943;
        System.out.println(new IntToRoman().intToRoman(num));
    }

    public String intToRoman(int num) {
        String[] roman = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] value = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num != 0) {
            while (num < value[i]) {
                ++i;
            }
            num -= value[i];
            res.append(roman[i]);
        }
        return res.toString();
    }
}
