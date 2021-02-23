package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    private void dfs(StringBuffer S, int index, List<String> res) {
        // 二叉树的深度优先遍历
        if (index == S.length()) {
            // 叶子结点退出条件
            res.add(new String(S));
            return;
        }
        // 结果为所有叶子结点集合，不用剪枝，不是回溯
        dfs(S, index + 1, res); // 左子树(不置大写)
        if (Character.isLetter(S.charAt(index))) {
            S.setCharAt(index, (char) (S.charAt(index) ^ 32));
            dfs(S, index + 1, res); // 右子树(置大写)
        }

    }

    public List<String> letterCasePermutation(String S) {
        /// dfs仅为一个深度优先遍历，而非回溯
        List<String> res = new ArrayList<>();
        dfs(new StringBuffer(S), 0, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
