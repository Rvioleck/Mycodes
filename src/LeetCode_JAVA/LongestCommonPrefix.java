package LeetCode_JAVA;

import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j - 1].length() == i)  // 这个if-else判断溢出
                    // 当下标遍历到数组长度（溢出），直接返回前i-1个字符
                    return strs[0].substring(0, i);
                else {
                    if (strs[j].charAt(i) != strs[j - 1].charAt(i)) { // 这个if-else判断相应字符是否相等
                        if (i == 0) { // 下标为0时，匹配长度为0时返回空
                            return "";
                        } else // 不满足时返回前i-1个字符
                            return strs[0].substring(0, i);
                    }
                }
            }
        }
        return strs[0]; // 全部顺利匹配完毕则第一个str为最大前缀
    }

    @Test
    public void test() {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"fl","f"};
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
