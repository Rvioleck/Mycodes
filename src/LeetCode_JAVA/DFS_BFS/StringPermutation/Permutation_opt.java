package LeetCode_JAVA.DFS_BFS.StringPermutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation_opt {
    /*
    * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
    * */

    public String[] permutation(String str){
        List<String> res = new ArrayList<>();
        dfs(str.toCharArray(), 0, res);
        return res.toArray(new String[0]);
    }

    // 回溯,str[0~i-1]已经确定
    public void dfs(char[] str, int i, List<String> res){
        if (i == str.length){
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; ++j){
            if (visit[str[j] - 'a']) continue;  // 分支限界剪枝
            visit[str[j] - 'a'] = true;
            swap(str, i, j);  // str[i~n]位置上的元素依次交换到str[i]上
            dfs(str, i + 1, res);
            swap(str, i, j);
        }
    }

    public void swap(char[] str, int i, int j){
        if (i == j) return;
        str[i] ^= str[j];
        str[j] ^= str[i];
        str[i] ^= str[j];
    }

    public static void main(String[] args) {
        String[] res = new Permutation_opt().permutation("abc");
        for (String s :
                res) {
            System.out.println(s);
        }
    }
}
