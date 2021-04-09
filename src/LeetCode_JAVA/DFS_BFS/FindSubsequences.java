package LeetCode_JAVA.DFS_BFS;

import java.util.*;

public class FindSubsequences {

    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        this.n = nums.length;
        dfs(res, one, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> one, int[] nums, int index) {
        if (one.size() >= 2 && one.size() <= n){
            res.add(new ArrayList<>(one));
        }
        // 借助 set 对 [idx + 1, nums.length - 1] 范围内的数去重。
        // 对于{1,2,1,1}而言，从idx=0开始的话
        // {1,2,1}不递增，通过①剪枝
        // {1,1(第二个)}和{1,1(第三个)}而言，通过②去重
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < n; i++) {
            if (one.size() >= 1 && nums[i] < one.get(one.size() - 1)) continue; // ①
            if (set.contains(nums[i])) continue; // ②
            one.add(nums[i]);
            set.add(nums[i]);
            dfs(res, one, nums, i + 1);
            one.remove(one.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        System.out.println(new FindSubsequences().findSubsequences(nums));
    }
}
