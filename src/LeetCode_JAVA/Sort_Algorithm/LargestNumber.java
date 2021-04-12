package LeetCode_JAVA.Sort_Algorithm;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : nums) {
            queue.offer(String.valueOf(num));
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        String ret = String.valueOf(res);
        return ret.charAt(0) == '0' ? "0" : ret;
    }

    public static void main(String[] args) {
//        int[] nums = {432, 43243};
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new LargestNumber().largestNumber(nums));
        System.out.println("1".compareTo("0"));
    }

}
