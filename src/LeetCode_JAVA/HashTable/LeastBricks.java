package LeetCode_JAVA.HashTable;

import java.util.*;

public class LeastBricks {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(new ArrayList<>(Arrays.asList(1,2,2,1)));
        wall.add(new ArrayList<>(Arrays.asList(3,1,2)));
        wall.add(new ArrayList<>(Arrays.asList(1,3,2)));
        wall.add(new ArrayList<>(Arrays.asList(2,4)));
        wall.add(new ArrayList<>(Arrays.asList(3,1,2)));
        wall.add(new ArrayList<>(Arrays.asList(1,3,1,1)));
        System.out.println(new LeastBricks().leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> bricks : wall){
            int len = bricks.size();
            int sum = 0;
            for (int i = 0; i < len - 1; ++i){
                sum += bricks.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxCount = Math.max(maxCount, entry.getValue());
        }
        return wall.size() - maxCount;
    }
}
