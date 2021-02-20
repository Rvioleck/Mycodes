package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int index){
//        res.add(new ArrayList<>(subset));   // n叉树，每次加入元素都要判断n个元素
//        for (int i = index; i < nums.length; i++) {
//            subset.add(nums[i]);
//            dfs(res, subset, nums, i + 1);
//            subset.remove(subset.size() - 1);
//        }
        if (index == nums.length){   // 二叉树，对每个元素进行是否加入树的判断
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(res, subset, nums, index + 1);  // 添加该元素时下层递归
        subset.remove(subset.size() - 1);

        dfs(res, subset, nums, index + 1);  // 不添加该元素时下层递归
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(res, subset, nums, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

}
