package LeetCode_JAVA.TrieTree;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 * <p>
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * <p>
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * <p>
 * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 */
public class MinimumLengthEncoding {

    Node root = new Node();

    public static void main(String[] args) {
        String[] words = new String[]{
                "abc", "bc", "abd", "ebc"
        };
        System.out.println(new MinimumLengthEncoding().minimumLengthEncoding(words));
    }

    public int insert(String word) {
        Node curNode = root;
        boolean isNew = false;
        int len = word.length();
        for (int i = len - 1; i >= 0; --i) {
            int idx = word.charAt(i) - 'a';
            if (curNode.next[idx] == null) {
                curNode.next[idx] = new Node();
                isNew = true;
            }
            curNode = curNode.next[idx];
        }
        return isNew ? len + 1 : 0;
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            len += insert(word);
        }
        return len;
    }

    /**
     * 前缀树
     */
    static class Node {
        Node[] next = new Node[26];

        Node() {
        }
    }


}
