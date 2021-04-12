package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Partition {

    int n;

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Partition().partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> one = new ArrayList<>();
        this.n = s.length();
        dfs(res, one, s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> one, String s, int index) {
        if (index == n) {
            res.add(new ArrayList<>(one));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (index + i > n) break;
            String sub = s.substring(index, index + i);
            if (!isPalindrome(sub)) continue;
            one.add(sub);
            dfs(res, one, s, index + i);
            one.remove(one.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
