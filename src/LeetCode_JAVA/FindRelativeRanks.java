package LeetCode_JAVA;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/relative-ranks/
 */
public class FindRelativeRanks {

    public static void main(String[] args) {
        int[] scores = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new FindRelativeRanks().findRelativeRanks(scores)));
    }

    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < score.length; ++i){
            map.put(score[i], i);
        }
        String[] res = new String[score.length];
        int n = score.length;
        while (!map.isEmpty()){
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            if (n == 3){
                res[entry.getValue()] = "Bronze Medal";
            } else if (n == 2){
                res[entry.getValue()] = "Silver Medal";
            } else if (n == 1){
                res[entry.getValue()] = "Gold Medal";
            } else {
                res[entry.getValue()] = String.valueOf(n);
            }
            n--;
        }
        return res;
    }

}
