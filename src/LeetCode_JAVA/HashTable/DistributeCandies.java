package LeetCode_JAVA.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/distribute-candies/
 */
public class DistributeCandies {

    public static void main(String[] args) {
        System.out.println(new DistributeCandies().distributeCandies(new int[]{1,1,2,2,3,3}));
    }

    public int distributeCandies(int[] candyType) {
        int candyNum = candyType.length;
        int girlNum = 0;
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType){
            if (set.add(candy)){
                girlNum++;
            }
            if (girlNum == candyNum / 2){
                return girlNum;
            }
        }
        return girlNum;
    }

}
