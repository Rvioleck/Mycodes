package LeetCode_JAVA;

import org.junit.Test;
import java.util.ArrayList;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // 无重复字符的最长子串
        if (s.length() == 1)
            return 1;
        ArrayList list = new ArrayList(); // 子串入ArrayList
        int result = 0, iSubList = -1; // iSubList初始化为-1 为子串在原串的位置
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i)) == false) {
                // 如果下个字符不存在子串中
                if (iSubList == -1) // 每次list为空后首次执行添加操作时
                    iSubList = i;   // 记住list的头在array中的坐标iSubList
                list.add(s.charAt(i)); // 将下个字符添加进ArrayList
            } else { // 如果下个字符不存在子串中，得到当前子串的长度，并把下标置为list中重复元素第一次出现时在原串s的位置
                result = Math.max(list.size(), result);
                int iList = list.indexOf(s.charAt(i)); // iList为重复元素在子串List中出现的位置
                i = s.indexOf(s.charAt(i), iSubList + iList); // iSubList+iList即为重复元素在原串中的位置
                list.clear(); // 清空List
                iSubList = -1; // 重置串位置iSubList
//                if (list.size() < result) {
//                    list.clear();
//                }
//                else {
//                    result = list.size();
//                    int iList = list.indexOf(s.charAt(i)); // iList为重复元素在子串List中出现的位置
//                    i = s.indexOf(s.charAt(i), iSubList + iList); // iSubList+iList即为重复元素在原串中的位置
//                    list.clear(); // 清空List
//                    iSubList = -1; // 重置串位置iSubList
//                }
            }
        }
        result = Math.max(result, list.size());
        return result;
    }

    @Test
    public void test1() {
        String s = "ggububgvfk";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
