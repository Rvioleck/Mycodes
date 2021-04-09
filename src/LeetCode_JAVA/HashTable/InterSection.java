package LeetCode_JAVA.HashTable;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class InterSection {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] res = new InterSection().intersection(nums1, nums2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            if (set1.contains(num2)){
                set2.add(num2);
            }
        }
        return set2.stream().mapToInt(Number::intValue).toArray(); // hashSet<Integer>转int[]
    }

}
