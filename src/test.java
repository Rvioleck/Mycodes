
import java.util.*;

public class test {

    int[][] nums;
    HashSet<Integer> set = new HashSet<>();
    HashSet<HashSet<Integer>> res = new HashSet<>();

    public void dfs(int i){
        res.add(new HashSet<>(set));
        for (int j = 0; j < 7; j++){
            if (nums[i][j] == 0) continue;
            if (set.contains(j)) continue;
            set.add(j);
            dfs(j);
            set.remove((Object)j);
        }
    }

    public int f(int[][] nums){
        this.nums = nums;
        for (int i = 0; i < 7; i++){
            set.add(i);
            res.add(set);
            dfs(i);
            set.remove((Object)i);
        }
        return res.size();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] nums = new int[][]{
                {0,1,0,0,0,1,0},
                {1,0,1,0,0,0,1},
                {0,1,0,1,0,0,1},
                {0,0,1,0,1,0,0},
                {0,0,0,1,0,1,1},
                {1,0,0,0,1,0,1},
                {0,1,1,0,1,1,0}
        };
        System.out.println(new test().f(nums));
    }

}
