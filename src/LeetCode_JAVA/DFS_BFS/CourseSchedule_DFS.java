package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class CourseSchedule_DFS {
    // dfs实现拓扑排序，并且输出拓扑结果

    private int[] vis;
    private final List<Integer> list = new ArrayList<>();
    private boolean valid = true;

    private void dfs(int v, int[][] prerequisites) {
        vis[v] = 1;   // vis = 1, v is under searching.
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == v) {
                if (vis[prerequisite[1]] == 0) {  // vis = 0, v has not been searched, keep traversing adjacent nodes.
                    dfs(prerequisite[1], prerequisites);
                } else if (vis[prerequisite[1]] == 1) { // vis = 1, graph is cyclic, return.
                    valid = false;
                    return;
                }
            }
        }
        vis[v] = 2;   // vis = 2, v has been searched
        list.add(v);  // add v to the result sequence
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        vis = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (vis[i] == 0) {  // if i has not been searched, take a DFS traverse.
                dfs(i, prerequisites);
            }
        }
        if (!valid) return new int[0];  // valid is false, return empty array.
        return list.stream().mapToInt(Integer::valueOf).toArray();  // else return topological sequence.
    }

    public static void main(String[] args) {
        int[][] prerequisities = new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
        };
        System.out.println(Arrays.toString(new CourseSchedule_DFS().findOrder(3, prerequisities)));
    }
}
