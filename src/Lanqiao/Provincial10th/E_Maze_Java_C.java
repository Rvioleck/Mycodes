package Lanqiao.Provincial10th;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class E_Maze_Java_C {

    static class node {
        int x;
        int y;
        int len;
        StringBuilder path;
        node(int x, int y, int len, StringBuilder path){
            this.x = x;
            this.y = y;
            this.len = len;
            this.path = path;
        }
    }
    char[][] maze;
    boolean[][] vis;
    int m, n;

    private boolean satisfy(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && maze[x][y] != '1';
    }

    private void bfs(){
        Queue<node> queue = new LinkedList<>();
        queue.offer(new node(0, 0, 0, new StringBuilder()));
        vis[0][0] = true;
        while (!queue.isEmpty()){
            node curr = queue.poll();
            if (curr.x == m - 1 && curr.y == n - 1){
                System.out.println(curr.path);
                break;
            }
            int x = curr.x, y = curr.y;
            if (satisfy(x + 1, y)){
                vis[x + 1][y] = true;
                queue.offer(new node(x + 1, y, curr.len + 1, new StringBuilder(curr.path.append('D'))));
            }
            if (satisfy(x, y - 1)){
                vis[x][y - 1] = true;
                queue.offer(new node(x, y - 1, curr.len + 1, new StringBuilder(curr.path.append('L'))));
            }
            if (satisfy(x, y + 1)){
                vis[x][y + 1] = true;
                queue.offer(new node(x, y + 1, curr.len + 1, new StringBuilder(curr.path.append('R'))));
            }
            if (satisfy(x - 1, y)){
                vis[x - 1][y] = true;
                queue.offer(new node(x - 1, y, curr.len + 1, new StringBuilder(curr.path.append('U'))));
            }
        }
    }

    private void getPath(char[][] maze){
        this.maze = maze;
        this.m = maze.length;
        this.n = maze[0].length;
        this.vis = new boolean[m][n];
        bfs();
    }

    public static void main(String[] args) {
        char[][] maze = new char[30][50];
        try {
            String encoding = "GBK";
            File file = new File("D:\\Java\\Intellij\\Mycodes\\src\\Lanqiao\\Provincial10th\\maze.txt");
            if (file.isFile() && file.exists()){
                InputStreamReader read =new InputStreamReader(
                        new FileInputStream(file), encoding
                );
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineText;
                int i = -1;
                while ((lineText = bufferedReader.readLine()) != null){
                    char[] oneLine = lineText.toCharArray();
                    maze[++i] = oneLine;
                }
                read.close();
            } else {
                System.out.println("找不到指定文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        new E_Maze_Java_C().getPath(maze);
    }
}
