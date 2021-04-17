package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class LetterCasePermutation {

    public void dfs(StringBuilder S, List<String> res, int idx, int len) {
        if (idx == len) {
            res.add(new String(S));
            return;
        }
        dfs(S, res, idx + 1, len); // 不转变
        if (!Character.isLetter(S.charAt(idx))) return;
        S.setCharAt(idx, (char) (S.charAt(idx) ^ 32));
        dfs(S, res, idx + 1, len); // 转变
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        dfs(new StringBuilder(S), res, 0, len);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
