package LeetCode_JAVA.TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairSums {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(target - num) && map.get(target - num) >= 1){
                map.put(target - num, map.get(target - num) - 1);
                res.add(new ArrayList<Integer>(){
                    {
                        add(target - num);
                        add(num);
                    }
                });
            } else {
                map.put(num, map.getOrDefault(num,0) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 5, 6};
        System.out.println(new PairSums().pairSums(nums, 11));
    }

}
