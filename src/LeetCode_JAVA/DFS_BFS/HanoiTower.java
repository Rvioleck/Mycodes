package LeetCode_JAVA.DFS_BFS;

public class HanoiTower {

    /**
     * 将1 ~ n从A移动到B，C为辅助
     * 等价于：
     * ①1 ~ n-1从A移动到C，B为辅助
     * ②n从A移动到B
     * ③1 ~ n-1从C移动到B，A为辅助
     * @param n 最大编号
     * @param from 源柱
     * @param to   目标柱
     * @param help 协助柱
     */
    public static void hanoiTower(int n, String from, String to, String help){
        if (n == 1){
            System.out.println("move " + n + " from " + from + " to " + to);
            return;
        }
        hanoiTower(n - 1, from, help, to);
        System.out.println("move " + n + " from " + from + " to " + to);
        hanoiTower(n - 1, help, to, from);
    }

    public static void main(String[] args) {
        hanoiTower(5, "A", "B", "C");
    }

}
