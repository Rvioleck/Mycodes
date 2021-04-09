package LeetCode_JAVA.HashTable;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 *
 *     对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 *     然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 *     如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 true ；不是，则返回 false
 *
 *
 */
public class IsHappy {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new IsHappy().isHappy(n));
        System.out.println(new IsHappy().isHappy2(n));
    }

    public boolean isHappy(int n) {
        int low = next(n), fast = next(next(n));
        while (low != fast) {
            if (low == 1 || fast == 1)
                return true;
            low = next(low);
            fast = next(next(fast));
        }
        return low == 1;
    }

    /**
     * HashSet实现
     */
    public boolean isHappy2(int n){
        HashSet<Integer> set = new HashSet<>();
        while (true){
            if (set.contains(n)){
                return false;
            }
            set.add(n);
            n = next(n);
            if (n == 1){
                return true;
            }
        }
    }

    public int next(int n) {
        int result = 0;
        while (n != 0) {
            result += Math.pow(n % 10, 2);
            n /= 10;
        }
        return result;
    }


}
