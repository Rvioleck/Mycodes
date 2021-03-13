package Lanqiao.Provincial10th;

public class B_YearString_C {

    /**
     * 本质上为求解10进制转为26进制的问题
     * @param year 年份year用于转换为26进制
     * @return year对应的26进制数
     */
    private String yearString(int year){
        char[] digits = new char[27];  // digits记录26进制所对应的26个字母A,B,...,Z (10进制对应十个符号0,1,...,9)
        for (int i = 1; i <= 26; i++) {
            digits[i] = (char) ('A' + i - 1);
        }
        // digits[1~26] = {'A', 'B', 'C', ... , 'Y', 'Z'};
        StringBuilder res = new StringBuilder(); // 类似于C的String，因为Java不定长String用StringBuilder
        while (year != 0){
            res.append(digits[year % 26]);
            year /= 26; // year为整数，计算结果强制类型转换结果为下取整
        }
        // 此时 res = QYB 因为StringBuilder的append是在字符串位追加，结果为正常顺序的反向
        return res.reverse().toString(); // 结果为res.reverse() == BYQ
    }
    // 2019 % 26 = 17 对应字母为Q
    // 2019 / 26 = 77
    // 77 % 26 = 25 对应字母为Y
    // 77 / 26 = 2
    // 2 % 26 = 2 对应字母为B
    // 2 / 26 = 0 退出循环

    public static void main(String[] args) {
        int year = 2019;
        System.out.println(new B_YearString_C().yearString(year));
        // res = BYQ
    }

}
