package LeetCode_JAVA.Greedy_Algorithm;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积。
 * 每次拆成n个3，如果剩下是4，则保留4，然后相乘
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4){
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new LeetCode_JAVA.DynamicProgram.IntegerBreak().integerBreak(n));
    }

}
