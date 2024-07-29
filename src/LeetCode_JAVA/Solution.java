package LeetCode_JAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer, List<Integer>> map = sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int res = binaryFind(nums, i + 1, nums.length - 1, target - nums[i]);
            if (res != -1) {
                return new int[]{i, res};
            }
        }
        return null;
    }

    public int binaryFind(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public TreeMap<Integer, List<Integer>> sort(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }

        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,0};
        System.out.println(Arrays.toString(new Solution().twoSum(nums, 0)));
    }
}