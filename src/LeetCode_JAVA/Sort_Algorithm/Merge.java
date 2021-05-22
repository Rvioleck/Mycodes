package LeetCode_JAVA.Sort_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class Merge {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(new Merge().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][];
        }
        // 按区间左边界进行排序
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            // 如果当前区间的左区间大于已经合并过的区间的最优区间，则一定为新区间
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else { // 否则则选择更大的右区间合并到已经合并区间中的最右区间中
                res.get(res.size() - 1)[1] = Math.max(r, res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
