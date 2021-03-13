package Lanqiao.Provincial10th;

public class F_SpecialNum_Java_C {

    /**
     * 求小于n的所有特殊数的和
     * @param n
     * @return ≤n的特殊数的和
     */
    private int getSpecialNum(int n){
        int sum = 0;  // 求和结果
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)){ // i是特殊数则求和
                sum += i;
            }
        }
        return sum;
    }

    /**
     * 判断是否为特殊数
     * @param n
     * @return 包含2或0或1或9 return true
     */
    private boolean isSpecial(int n) {
        while (n != 0){
            int digit = n % 10;
            if (digit == 2 || digit == 0 || digit == 1 || digit == 9){
                return true;
            }
            n /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 40;
        System.out.println("求和为: " + new F_SpecialNum_Java_C().getSpecialNum(n));
    }


}
