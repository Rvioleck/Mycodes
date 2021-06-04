package LeetCode_JAVA.DFS_BFS;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 * 这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *     例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CourseSchedule_BFS {
    // bfs实现拓扑排序，并且输出拓扑结果

    public static void main(String[] args) {
        int[][] prerequisities = new int[][]{
                {0, 1},
                {0, 2},
                {2, 1}
        };
        System.out.println(new CourseSchedule_BFS().canFinish(3, prerequisities));
        System.out.println(Arrays.toString(new CourseSchedule_BFS().findOrder(3, prerequisities)));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // inDegree array records the initial in degree of all nodes.
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }
        // put all the nodes whose in degree is 0 to the stack.
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.push(i);
            }
        }
        // similar to BFS: loop the nodes with 0 in degree.
        int count = 0;
        while (!deque.isEmpty()) {
            int i = deque.pop();
            count++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == i) {
                    if (--inDegree[prerequisite[1]] == 0) {
                        // after process, the nodes with 0 in degree are put on the stack.
                        deque.push(prerequisite[1]);
                    }
                }
            }
        }
        // if the graph is cyclic, then count is not equal to numCourses, return false.
        // else the graph is acyclic, return true.
        return count == numCourses;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // result array records the topological sequence of the graph.
        int[] result = new int[numCourses];
        // inDegree array records the initial in degree of all nodes.
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }
        // put all the nodes whose in degree is 0 to the stack.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        // similar to BFS: loop the nodes with 0 in degree.
        int count = 0;
        while (!stack.isEmpty()) {
            int i = stack.pop();
            result[numCourses - ++count] = i;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == i) {
                    if (--inDegree[prerequisite[1]] == 0) {
                        // after process, the nodes with 0 in degree are put on the stack.
                        stack.push(prerequisite[1]);
                    }
                }
            }
        }
        // if the graph is cyclic, then count is not equal to numCourses, return empty array.
        // else the graph is acyclic, return result.
        return count == numCourses ? result : new int[0];
    }
}
