package LeetCode_JAVA.HashTable;

import java.util.Map;
import java.util.TreeMap;

public class CountKDifference {

    public int countKDifference(int[] nums, int k) {
        // 时间复杂度：O(n)，空间复杂度：O(n)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()){
            if (map.containsKey(key + k)){
                res += map.get(key) * map.get(key + k);
            }
        }
        return res;
    }

    public int countKDifference2(int[] nums, int k) {
        // 数组代替TreeMap
        int[] map = new int[101];
        for (int num : nums){
            map[num]++;
        }
        int res = 0;
        for (int i = 0; i <= 100 - k; ++i){
            res += map[i] * map[i + k];
        }
        return res;
    }

}
