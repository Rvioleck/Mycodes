package Lanqiao.Provincial10th;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class E_Maze_Java_C {
    // 广度优先搜索bfs

    /**
     * node类记录迷宫每个坐标的信息
     */
    static class node {
        int x;       // 迷宫的x坐标
        int y;       // 迷宫的y坐标
        int len;     // 到(x, y)时已走步长
        StringBuilder path; // 记录走到(x, y)时其之前的路径
        node(int x, int y, int len, StringBuilder path){
            // 构造函数
            this.x = x;
            this.y = y;
            this.len = len;
            this.path = path;
        }
    }
    char[][] maze;   // 全局变量maze记录迷宫信息
    boolean[][] vis; // 记录迷宫的结点(x, y)是否被访问
    int m, n;        // 迷宫的长m和宽n

    /**
     * @param maze char[][]迷宫数组
     */
    private void getPath(char[][] maze){
        // 将传入参数赋为全局变量(避免函数调用时的复杂传参)
        this.maze = maze;
        this.m = maze.length;
        this.n = maze[0].length;
        this.vis = new boolean[m][n];
        bfs();
    }

    private boolean satisfy(int x, int y){
        // 判断当前结点是否可以遍历
        // 横坐标 0 <= x < m, 纵坐标 0 <= y < n
        // !vis[x][y] 等价于 vis[x][y] == false 即坐标(x, y)未被访问过
        // maze[x][y] != '1' 等价于 maze[x][y] == '0' 即坐标(x, y)可以通行
        // 满足上述所有条件就证明当前结点可以满足通行
        return x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && maze[x][y] != '1';
    }

    /**
     * bfs 广度优先遍历，遍历迷宫找到最短路
     * 因为此题需要求最短路径，所以不能使用深度优先遍历
     * 其中遍历路径的优先级为 DLRU
     * 对于bfs类题目必须熟练运用模板
     */
    private void bfs(){
        Queue<node> queue = new LinkedList<>(); // 队列Queue，数据元素为node类
        queue.offer(new node(0, 0, 0, new StringBuilder()));
        // 从结点(0, 0)开始，所以将其入队类，node(0, 0, 0, "")
        // 对于第一个结点其坐标为(0, 0)，已走步长为0，已走路径为""(空字符串)
        vis[0][0] = true; // 且第一个结点已经被访问
        while (!queue.isEmpty()){
            // 此处开始套bfs模板
            node curr = queue.poll(); // 获取当前结点curr(第一次循环即为node(0, 0, 0, ""))
            if (curr.x == m - 1 && curr.y == n - 1){ // 此处为退出条件
                // 当当前结点坐标(x, y)为m - 1, n - 1时，即迷宫最右下角时
                System.out.println(curr.path); // 输出当前结点记录的路径path并结束程序
                return;
            }
            int x = curr.x, y = curr.y; // curr.x 和curr.y 是上述出队的结点curr的x和y坐标
            if (satisfy(x + 1, y)){  // 如果(x + 1, y) 满足条件
                vis[x + 1][y] = true;   // 标记访问，且将其入队
                // x + 1, y 相对x, y是向下走， 入队的结点len需要相对+1, 横坐标需要相应+1, 向下走对应D，路径相应+D (.append('D'))
                queue.offer(new node(x + 1, y, curr.len + 1, new StringBuilder(curr.path.append('D'))));
            }
            if (satisfy(x, y - 1)){ // 同上
                vis[x][y - 1] = true;  // 此时y - 1代表的是向左走，路径相应+L
                queue.offer(new node(x, y - 1, curr.len + 1, new StringBuilder(curr.path.append('L'))));
            }
            if (satisfy(x, y + 1)){
                vis[x][y + 1] = true;  // 此时y + 1代表的是向右走，路径相应+R
                queue.offer(new node(x, y + 1, curr.len + 1, new StringBuilder(curr.path.append('R'))));
            }
            if (satisfy(x - 1, y)){
                vis[x - 1][y] = true;  // 此时x - 1代表的是向上走，路径相应+U
                queue.offer(new node(x - 1, y, curr.len + 1, new StringBuilder(curr.path.append('U'))));
            }
        }
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
