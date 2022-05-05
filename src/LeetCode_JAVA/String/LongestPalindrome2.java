package LeetCode_JAVA.String;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * dp[i][j] = dp[i + 1][j - 1]
 * dp[i][j] = 0
 */
public class LongestPalindrome2 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // Manacher算法思路
    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] str = getChars(s);
        int[] pArr = new int[str.length];
        int C = -1, R = -1;
        int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; ++i){
            pArr[i] = R > i ? Math.min(R - i, pArr[2 * C - i]) : 1;
            while (i - pArr[i] >= 0 && i + pArr[i] < str.length && str[i - pArr[i]] == str[i + pArr[i]]){
                pArr[i]++;
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > maxR){
                maxR = pArr[i];
                maxC = i;
            }
        }
        char[] res = new char[maxR - 1];
        int index = maxC - maxR + 2;
        for (int i = 0; i < res.length; ++i){
            res[i] = str[index];
            index += 2;
        }
        return String.valueOf(res);
    }

    public char[] getChars(String s){
        char[] chars = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < chars.length; ++i){
            chars[i] = ((i & 1) == 0) ? '#' : s.charAt(index++);
        }
        return chars;
    }
}

