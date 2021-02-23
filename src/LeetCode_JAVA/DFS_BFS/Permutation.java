package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private void dfs(String S, StringBuffer path, List<String> res, boolean[] vis) {
        if (path.length() == S.length()) {
            res.add(new String(path));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (vis[i]) continue;
            vis[i] = true;
            path.append(S.charAt(i));
            dfs(S, path, res, vis);
            path.deleteCharAt(path.length() - 1);
            vis[i] = false;
        }
    }

    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        boolean[] vis = new boolean[S.length()];
        dfs(S, path, res, vis);
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
//        System.out.println(new Permutation().permutation("abc"));
        String[] res = new Permutation().permutation("abc");
        for (String s :
                res) {
            System.out.println(s);
        }
    }
}
