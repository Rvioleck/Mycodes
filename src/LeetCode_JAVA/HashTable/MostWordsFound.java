package LeetCode_JAVA.HashTable;

public class MostWordsFound {
    /*
    * https://leetcode.cn/problems/maximum-number-of-words-found-in-sentences/
    * */

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences){
            int len = sentence.split(" ").length;
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MostWordsFound().mostWordsFound(new String[]{
                "alice and bob love leetcode", "i think so too", "this is great thanks very much"
        }));
    }
}
