package Lanqiao.Provincial10th;

import java.util.List;

public class A_Group_Java_C {
    // 深度优先搜索dfs(回溯)

    private int res = 0;    // 全局变量res记录最优组队的结果
    private boolean[] vis;  // vis数组标记第i个球员是否被选为首发(每个队员只能被选择至多一次，所以被选择后将其标记为true)
    private int m, n;       // 记录数据的行数m = 20, 列数n = 5

    /**
     * @param team 传入的二维数组 20×5 的数据(List<List<Integer>> team 可以看作C中的 int[][] team)
     * @return 返回评分之和的最大结果
     */
    public int group(List<List<Integer>> team){
        m = team.size();         // playerNum = 20 (数组下标为0 <= i <= 19)
        n = team.get(0).size();  // quotaNum = 5   (数组下标为0 <= j <= 4)
        vis = new boolean[m];    // m = 20组默认初始化为false
        dfs(team, 0, 0); // 进行深度优先搜索(初始从第0 + 1号位开始，初始评分为0)
        return res;
    }

    /**
     * @param team 传入的二维数组 20×5 的数据
     * @param index 遍历到第 index + 1号位(总共有5号位且index从0开始)
     * @param sum 遍历到第 index + 1号球员时的评分之和是多少
     */
    private void dfs(List<List<Integer>> team, int index, int sum) {
        if (index == n){     // dfs函数的递归出口 index = 5时退出 (index = 0..4已经遍历结束后)
            if (sum > res){  // 如果当前的dfs函数遍历sum结果大于res
                res = sum;   // 更新当前的最大值res
            }
            return;          // index = 5时当前的dfs就结束了，直接退出
        }
        for (int i = 0; i < m; i++) {           // 对第1到m=20号球员进行遍历
            if (vis[i]) continue;               // 回溯剪枝，vis[i] == true的时候终止此次循环(即忽略i的情况，因为此时队员已被选择)
            int value = team.get(i).get(index); // 得到第 i+1 号球员如果在 index+1 号位时
            vis[i] = true;                      // 将 i+1 号球员的vis置为true，代表第 i+1 号球员已经被选择了
            dfs(team, index + 1, sum + value); // dfs递归继续考虑index + 2号位的情况
            // 此时的评分之和要加上当前球员的评分value
            vis[i] = false;   // 回溯模板中需要将引用变量复位
            // 可以理解为当上述dfs执行完了之后，i+1号球员为true的情况就已经执行完了，剩下的情况仍是i+1号球员为false的情况
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> team = GetText.getText("D:\\Java\\Intellij\\Mycodes\\src\\Lanqiao\\Provincial10th\\team.txt");
        System.out.println(new A_Group_Java_C().group(team));
    }
}
