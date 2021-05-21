package LeetCode_JAVA.TwoPointer.SlideWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int n = s.length();
        int windowLen = 0;
        int i = 0; // 窗口开始位置
        for (int j = 0; j < n; ++j){
            int idx = s.charAt(j);    // 获得当前字符的ASCII码值，用于存入数组进行下标索引
            i = Math.max(i, last[idx] + 1);  // 窗口前指针移动到字符idx的下一位下标(如果字符存在窗口内(必然大于i，否则小于i))
            windowLen = Math.max(windowLen, j - i + 1);  // 窗口大小为 j - i + 1
            last[idx] = j; // 记录当前字符出现位置
        }
        return windowLen;
    }

}
