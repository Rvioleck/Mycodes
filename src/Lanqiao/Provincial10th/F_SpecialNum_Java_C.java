package Lanqiao.Provincial10th;

public class F_SpecialNum_Java_C {

    private int getSpecialNum(int n){
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)){
                count++;
                sum += i;
            }
        }
        System.out.println("个数为: " + count);
        return sum;
    }

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
        int n = 10000;
        System.out.println("求和为: " + new F_SpecialNum_Java_C().getSpecialNum(n));
    }


}
