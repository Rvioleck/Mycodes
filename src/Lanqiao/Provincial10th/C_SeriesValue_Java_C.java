package Lanqiao.Provincial10th;

public class C_SeriesValue_Java_C {

    /**
     * 给定项数index求出特定数列，结果保留四位整数
     * f(n) = f(n - 1) + f(n - 2) + f(n - 3), n >= 4
     * f(1) = f(2) = f(3) = 1
     * 1, 1, 1, 3, 5, 9, 17, ..., ...
     * @param index 项数index
     * @return f(index) % 10000
     */
    private int getValue(int index){
        // 迭代实现，递归的空间消耗太大无法实现
        if (index <= 3){ // f(1) = f(2) = f(3) = 1
            return 1;
        }
        index -= 3; // 从第4项开始，将其视为第1项开始计算
        int i1 = 1, i2 = 1, i3 = 1; // i1, i2, i3分别为下个元素的前3, 2, 1个元素
        while (index-- != 0){
            // ① 3 ② 5 ③ 9
            int sum = (i1 + i2 + i3) % 10000; // sum = 3+5+9 = 17
            i1 = i2;    // ① 5
            i2 = i3;    // ② 9
            i3 = sum;   // ③ 17
        }
        return i3;
    }


    public static void main(String[] args) {
        int index = 20190324;
        System.out.println(new C_SeriesValue_Java_C().getValue(index));
    }

}
