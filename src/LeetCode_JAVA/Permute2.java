package LeetCode_JAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute2 {
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] vis){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue;
            path.add(nums[i]);
            vis[i] = true;
            dfs(nums, path, res, vis);
            path.remove(path.size() - 1);
            vis[i] = false;
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, path, res, vis);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Permute2().permuteUnique(new int[]{1, 1, 2}));
    }
}
