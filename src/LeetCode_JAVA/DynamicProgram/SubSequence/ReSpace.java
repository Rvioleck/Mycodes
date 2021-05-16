package LeetCode_JAVA.DynamicProgram.SubSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/re-space-lcci/
 * 你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 当substring(j, i)产生匹配时: dp[i] = min(dp[i], dp[j])
 * 当未产生匹配时: dp[i] = dp[i - 1] + 1
 * 复杂度开销主要在判断substring(j, i)是否产生匹配，可用trie树进行优化
 */
public class ReSpace {

    public static void main(String[] args) {
        String[] dictionary = new String[]{
                "looked","just","like","her","brother"
        };
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(new ReSpace().respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        int[] dp = new int[n + 1];
        // dp[i] 表示考虑前i个字符最少的未识别的字符数量
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        for (int i = 1; i <= n; ++i){
            dp[i] = dp[i - 1] + 1; // 当不产生匹配时，最少识别的字符数量正常+1
            for (int j = 0; j < i; ++j){
                if (set.contains(sentence.substring(j, i))){
                    // 当产生匹配时，前i个字符最少识别的字符数量为第(j)~(i-1)组成的字符串匹配时的最小值dp[j]
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }

}
