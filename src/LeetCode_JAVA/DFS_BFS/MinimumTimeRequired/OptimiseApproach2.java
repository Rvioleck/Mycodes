package LeetCode_JAVA.DFS_BFS.MinimumTimeRequired;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 *
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 优化方法：将最大花费的任务优先分配给最少工作时间的工人
 * 本递归树还是那棵递归树，本质上，我们并没有主动的否决某些方案（也就是我们并没有改动递归树）
 * 我们只是调整了搜索顺序来剪枝掉了一些「必然不是最优」的搜索路径。
 */
public class OptimiseApproach2 {

    public static void main(String[] args) {
        int[] jobs = {11,2,20,18,2,1,7,11,7,10};
        int k = 9;
        System.out.println(new OptimiseApproach2().minimumTimeRequired(jobs, k));
    }

    int k;
    int[] jobs;
    int ans = 0x3f3f3f3f;

    /**
     * @param _jobs 每个工作的耗时情况
     * @param _k 共有k个工人
     * @return 工作时间最大的工人最短时的工作时间 。
     */
    public int minimumTimeRequired(int[] _jobs, int _k) {
        Arrays.sort(_jobs);
        jobs = _jobs;
        int n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(n - 1, sum, 0);
        return ans;
    }

    /**
     * @param u 当前分配的任务下标
     * @param sum 工人分配的情况sum[i]表示第i个员工的工作量
     * @param max 当前的[最大工作时间]
     */
    public void dfs(int u, int[] sum, int max){
        if (max > ans) return;
        if (u == -1){
            ans = max;
            return;
        }
        Arrays.sort(sum = sum.clone());
        for (int i = 0; i < k; i++) {
            if (i > 0 && sum[i] == sum[i - 1]) continue;
            sum[i] += jobs[u];
            dfs(u - 1, sum, Math.max(max, sum[i]));
            sum[i] -= jobs[u];
        }
    }

}
