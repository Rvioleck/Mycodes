package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack.SimilarToCKS;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j + 1 > n) continue;
                String word = s.substring(j, i); // 子串j ~ i-1
                if (wordDict.contains(word) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    // dp[j] 前j个字母组成的单词能否被字典组成
    // dp[j] = dp[j - word] || dp[j]

}
