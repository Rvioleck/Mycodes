package LeetCode_JAVA.HashTable;

import java.util.HashMap;

public class FindPairs {

    public int findPairs(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer cur : map.keySet()){
            if (k != 0){
                if (map.containsKey(cur + k)){
                    res++;
                }
            } else {
                if (map.containsKey(cur) && map.get(cur) > 1){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindPairs().findPairs(new int[]{2, 3, 1, 5, 9, 0}, 1));
    }
}
