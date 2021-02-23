package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    private boolean[] vis;

    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int index) {
        res.add(new ArrayList<>(subset));   // n叉树，每次加入元素都要判断n个元素
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            dfs(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, subset, nums, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
