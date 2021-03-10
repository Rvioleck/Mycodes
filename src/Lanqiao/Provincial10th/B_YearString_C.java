package Lanqiao.Provincial10th;

public class B_YearString_C {

    private String yearString(int year){
        char[] digits = new char[27];
        for (int i = 1; i <= 26; i++) {
            digits[i] = (char) ('A' + i - 1);
        }
        StringBuilder res = new StringBuilder();
        while (year != 0){
            res.append(digits[year % 26]);
            year /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        int year = 2019;
        System.out.println(new B_YearString_C().yearString(year));
    }

}
