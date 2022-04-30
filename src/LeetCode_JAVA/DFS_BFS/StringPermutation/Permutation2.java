package LeetCode_JAVA.DFS_BFS.StringPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

    private void dfs(String S, StringBuffer path, List<String> res, boolean[] vis) {
        if (path.length() == S.length()) {
            res.add(new String(path));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (vis[i]) continue;
            if (i > 0 && S.charAt(i) == S.charAt(i - 1) && !vis[i - 1])
                continue;
            path.append(S.charAt(i));
            vis[i] = true;
            dfs(S, path, res, vis);
            path.deleteCharAt(path.length() - 1);
            vis[i] = false;
        }
    }

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        S = String.valueOf(chars);
        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        boolean[] vis = new boolean[S.length()];
        dfs(S, path, res, vis);
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] res = new Permutation2().permutation("aba");
        for (String s :
                res) {
            System.out.println(s);
        }
    }

}
