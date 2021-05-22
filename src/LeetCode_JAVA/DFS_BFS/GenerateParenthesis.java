package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new GenerateParenthesis().generateParenthesis(n));
    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuffer one = new StringBuffer();
        dfs(one, n, n);
        return res;
    }

    public void dfs(StringBuffer one, int left, int right){
        if (left > right || left < 0){
            return;
        }
        if (left == 0 && right == 0){
            res.add(new String(one));
            return;
        }
        dfs(one.append('('), left - 1, right);
        one.deleteCharAt(one.length() - 1);
        dfs(one.append(')'), left, right - 1);
        one.deleteCharAt(one.length() - 1);
    }
}
