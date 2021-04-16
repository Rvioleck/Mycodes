package LeetCode_JAVA.DFS_BFS;

import java.util.Arrays;

public class FloodFill_DFS {

    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        for (int i = 0; i <= 3; i++){
            dfs(image, sr + dir[i][0], sc + dir[i][1], newColor, oldColor);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,2,1}};
        System.out.println(Arrays.deepToString(new FloodFill_DFS().floodFill(image, 1, 1, 1)));
    }

}
