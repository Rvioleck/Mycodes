import java.util.*;

public class test{
    private int m, n;

    private void dfs(int[][] maze, int x, int y, List<List<Integer>> path, int len){
        if (x < 0 || y < 0 || x >= m || y >= n || maze[x][y] == 1){
            return;
        }
        path.add(new ArrayList<Integer>(){
            {
                add(x);
                add(y);
            }
        });
        maze[x][y] = 1;
        if (x == m - 1 && y == n - 1){
//            maze[x][y] = 1;
            for (List<Integer> point : path) {
                System.out.println(point);
            }
            System.out.println(len);
            return;
        }
        dfs(maze, x, y + 1, path, len + 1);
        dfs(maze, x, y - 1, path, len + 1);
        dfs(maze, x + 1, y, path, len + 1);
        dfs(maze, x - 1, y, path, len + 1);
        maze[x][y] = 0;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = 4, n = 6;
        int[][] maze = new int[][]{
                {0,1,0,0,0,0},
                {0,0,0,1,0,0},
                {0,0,1,0,0,1},
                {1,1,0,0,0,0}
        };
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] maze = new int[m][n];
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                maze[i][j] = sc.nextInt();
//            }
//        }
        test obj = new test();
        obj.m = m;
        obj.n = n;
        List<List<Integer>> path = new ArrayList<>();
        obj.dfs(maze, 0, 0, path, -1);
    }
}