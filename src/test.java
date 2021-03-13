import java.util.LinkedList;
import java.util.Queue;

public class test {

    private int count = 0;

    private int getPathNum(boolean[][] graph, int n){
        for (int i = 0; i < n; i++) {
            bfs(graph, i, n);
        }
        return count;
    }

    private void bfs(boolean[][] graph, int i, int n) {
        // 从结点i开始
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()){
            int v = queue.remove();
            for (int j = v + 1; j < n; j++) {
                if (graph[v][j]){
                    count++;
                    queue.add(j);
                }
            }
        }
    }


    public static void main(String[] args) {
        boolean[][] graph = new boolean[7][7];
        graph[0][1] = true;
        graph[0][5] = true;
        graph[1][2] = true;
        graph[1][6] = true;
        graph[2][3] = true;
        graph[2][6] = true;
        graph[3][4] = true;
        graph[4][5] = true;
        graph[4][6] = true;
        graph[5][6] = true;
        System.out.println(new test().getPathNum(graph, 7));
    }


}