package LeetCode_JAVA.TwoPointer.BinarySearch;

public class MySqrt {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int low = 0, high = x;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid <= x) {
                low = mid;
            } else
                high = mid;
        }
        return low;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = left + right + 1 >> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public static void main(String[] args) {
        MySqrt ms = new MySqrt();
        int x = 9;
        System.out.println(ms.mySqrt(x));
    }
}
