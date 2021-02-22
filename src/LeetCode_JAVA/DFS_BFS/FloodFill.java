package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor){
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()){
            int[] point = queue.remove();
            int r = point[0], c = point[1];
            image[r][c] = newColor;
            if (r - 1 >= 0 && image[r - 1][c] == color){
                queue.offer(new int[]{r - 1, c});
            }
            if (r + 1 < m && image[r + 1][c] == color){
                queue.offer(new int[]{r + 1, c});
            }
            if (c - 1 >= 0 && image[r][c - 1] == color){
                queue.offer(new int[]{r, c - 1});
            }
            if (c + 1 < n && image[r][c + 1] == color){
                queue.offer(new int[]{r, c + 1});
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
        };
        image = new FloodFill().floodFill(image, 1, 1, 1);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
