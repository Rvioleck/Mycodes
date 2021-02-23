package LeetCode_JAVA;

public class Fib {
    public int fib(int n) {
        int f0 = 0, f1 = 1, result = 0;
        if (n == 0)
            return f0;
        if (n == 1)
            return f1;
        for (int i = 1; i < n; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }

}
