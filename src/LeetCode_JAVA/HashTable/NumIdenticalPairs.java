package LeetCode_JAVA.HashTable;

import java.util.HashMap;

public class NumIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        // O(n²)
        int res = 0;
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                if (nums[i] == nums[j]){
                    res++;
                }
            }
        }
        return res;
    }

    public int numIdenticalPairs2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int val : map.values()){
            res += (val * (val - 1)) >> 1;
        }
        return res;
    }

    public int numIdenticalPairs3(int[] nums) {
        int[] map = new int[101];
        for (int num : nums){
            map[num] += 1;
        }
        int res = 0;
        for (int num : map){
            res += (num * (num - 1)) >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumIdenticalPairs().numIdenticalPairs(new int[]{1,2,3,1,2,3,2,1,2,3,2,1,2,3,2,1,3}));
        System.out.println(new NumIdenticalPairs().numIdenticalPairs2(new int[]{1,2,3,1,2,3,2,1,2,3,2,1,2,3,2,1,3}));
    }

}
