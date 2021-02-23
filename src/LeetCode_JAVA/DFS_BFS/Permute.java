package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, res);
        return res;
    }

    private void dfs(int[] nums,
                     List<Integer> path,
                     List<List<Integer>> res) {
        if (path.size() == nums.length) {  // dfs的退出
            if (!res.contains(path))
                res.add(new ArrayList<>(path)); // 遍历到叶结点时添加到结果集
            return;
        }
        for (int i = 0; i < nums.length; i++) {  // 遍历子孙结点
            if (path.contains(nums[i])) continue;  // i存在于path中时剪枝，不遍历此子树
            path.add(nums[i]);          // 该结点一定为不存在path中的新结点，将该结点加入path(类似于前序处理该结点)
            dfs(nums, path, res);       // 继续向下遍历
            path.remove(path.size() - 1);  // 原路返回，删除path最尾部的结点(类似于后序处理该结点)

        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
}
