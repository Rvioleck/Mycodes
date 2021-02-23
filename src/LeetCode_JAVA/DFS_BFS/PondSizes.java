package LeetCode_JAVA.DFS_BFS;

import java.util.*;

public class PondSizes {
    private List<Integer> res = new ArrayList<>();
    private int curSize = 0;
    private int m, n;

    private void bfs(int[][] land, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            int i = point[0], j = point[1];
            if (i < 0 || i >= m || j < 0 || j >= n || land[i][j] != 0) {
                continue;
            }
            land[i][j] = -1;
            curSize++;
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i + 1, j + 1});
            queue.offer(new int[]{i - 1, j + 1});
            queue.offer(new int[]{i + 1, j - 1});
            queue.offer(new int[]{i - 1, j - 1});
            queue.offer(new int[]{i, j + 1});
            queue.offer(new int[]{i, j - 1});
        }
    }

    public int[] pondSizes(int[][] land) {
        m = land.length;
        if (m == 0) {
            return new int[0];
        }
        n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    bfs(land, i, j);
                    res.add(curSize);
                    curSize = 0;
                }
            }
        }
        int[] ret = res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        int[][] land = new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] ret = new PondSizes().pondSizes(land);
        for (int x :
                ret) {
            System.out.print(x + " ");
        }
    }
}
