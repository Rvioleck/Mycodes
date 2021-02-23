package LeetCode_JAVA.DFS_BFS;

import java.util.Arrays;
import java.util.Stack;

public class CanFinish {
    // bfs实现拓扑排序，并且输出拓扑结果

    public static void main(String[] args) {
        int[][] prerequisities = new int[][]{
                {0, 1},
                {0, 2},
                {2, 1}
        };
        System.out.println(new CanFinish().canFinish(3, prerequisities));
        System.out.println(Arrays.toString(new CanFinish().findOrder(3, prerequisities)));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            count++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == i) {
                    if (--inDegree[prerequisite[1]] == 0) {
                        // after process, the nodes with 0 in degree are put on the stack.
                        stack.push(prerequisite[1]);
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
        if (count != numCourses) {
            return new int[0];
        } else {
            return result;
        }
    }
}
