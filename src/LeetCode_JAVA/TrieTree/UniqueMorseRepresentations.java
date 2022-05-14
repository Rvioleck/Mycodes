package LeetCode_JAVA.TrieTree;

public class UniqueMorseRepresentations {

    static class TrieNode {
        boolean isEnd;
        TrieNode nextNode0;
        TrieNode nextNode1;
        TrieNode(){
            isEnd = false;
            nextNode0 = null;
            nextNode1 = null;
        }
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TrieNode trie = new TrieNode();
        int res = 0;
        for (String word : words){
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); ++i){
                char[] code = codes[word.charAt(i) - 'a'].toCharArray();
                for (char c : code) {
                    if (c == '.') {
                        if (cur.nextNode0 == null) {
                            cur.nextNode0 = new TrieNode();
                        }
                        cur = cur.nextNode0;
                    } else {
                        if (cur.nextNode1 == null) {
                            cur.nextNode1 = new TrieNode();
                        }
                        cur = cur.nextNode1;
                    }
                }
            }
            if (!cur.isEnd){
                cur.isEnd = true;
                res++;
            }
        }
        return res;
    }

}
