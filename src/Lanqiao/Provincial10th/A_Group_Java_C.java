package Lanqiao.Provincial10th;

import java.util.List;

public class A_Group_Java_C {

    private int res = 0;
    private boolean[] vis;
    private int m, n;

    public int group(List<List<Integer>> team){
        m = team.size(); // playerNum = 20
        n = team.get(0).size(); // quotaNum = 5
        vis = new boolean[m];
        dfs(team, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> team, int index, int sum) {
        if (index == n){
            if (sum > res){
                res = sum;
            }
            return;
        }
        for (int i = 0; i < m; i++) {
            if (vis[i]) continue;
            int value = team.get(i).get(index);
            vis[i] = true;
            dfs(team, index + 1, sum + value);
            vis[i] = false;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> team = GetText.getText("D:\\Java\\Intellij\\Mycodes\\src\\Lanqiao\\Provincial10th\\team.txt");
        System.out.println(new A_Group_Java_C().group(team));
    }
}
