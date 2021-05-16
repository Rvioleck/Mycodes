package LeetCode_JAVA.TrieTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/re-space-lcci/
 * 你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 当substring(j, i)产生匹配时: dp[i] = min(dp[i], dp[j])
 * 当未产生匹配时: dp[i] = dp[i - 1] + 1
 * 复杂度开销主要在判断substring(j, i)是否产生匹配，可用trie树进行优化
 * 由于dp遍历时已知为区间的右界i，因此在使用trie树优化时使用后缀树(逆序插入)较好
 */
public class ReSpace2 {

    public static void main(String[] args) {
        String[] dictionary = new String[]{
                "ab", "abb", "bb"
        };
        String sentence = "acbbabb";
        System.out.println(new ReSpace2().respace(dictionary, sentence));
    }

    static class Node {
        Node[] next;
        Boolean isEnd; // 标记是否是单词结尾
        Node(){
            isEnd = false;
            next = new Node[26];
        }
    }

    /**
     * @param root root为根据字典dict所构造的字典树(后缀树)
     * @param dictionary 字典dict
     */
    public void makeTrie(Node root, String[] dictionary){
        for (String word : dictionary){
            int len = word.length();
            Node curNode = root;
            for (int i = len - 1; i >= 0; --i){
                int idx = word.charAt(i) - 'a';
                if (curNode.next[idx] == null){
                    curNode.next[idx] = new Node();
                }
                curNode = curNode.next[idx];
            }
            curNode.isEnd = true;
        }
    }

    /**
     * @param root 所查找的字典树(逆序存储了dictionary)(后缀树)
     * @param sentence 所查找的原句子
     * @param endPos 查找的结尾位置
     * @return 返回 sentence 中以 endPos 为结尾的在 dict 中的单词，返回这些单词的开头下标。
     */
    public List<Integer> search(Node root, String sentence, int endPos){
        List<Integer> indices = new ArrayList<>();
        Node curNode = root;
        for (int i = endPos - 1; i >= 0; --i){
            int idx = sentence.charAt(i) - 'a';
            if (curNode.next[idx] == null){
                // 对应元素不在字典树中，直接返回
                break;
            }
            curNode = curNode.next[idx];
            if (curNode.isEnd){
                // 对应元素满足isEnd为dict中的单词，记录下标
                indices.add(i);
            }
        }
        return indices;
    }

    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        int[] dp = new int[n + 1]; // dp[i] 表示考虑前i个字符最少的未识别的字符数量
        Node root = new Node();
        makeTrie(root, dictionary);
        for (int i = 1; i <= n; ++i){
            dp[i] = dp[i - 1] + 1;
            for (int j : search(root, sentence, i)){ // j为所有以i-1结尾的元素，所构成的单词存在于dict中的前下标
                dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[n];
    }

}
