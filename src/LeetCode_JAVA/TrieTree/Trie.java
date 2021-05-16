package LeetCode_JAVA.TrieTree;

/**
 *   Your Trie object will be instantiated and called as such:
 *   Trie obj = new Trie();
 *   obj.insert(word);
 *   boolean param_2 = obj.search(word);
 *   boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {

    /** The data of each node. */
    char val;

    /** Mark the node whether the last character. */
    boolean isEnd;

    /** Store the next node of the trie tree.
     * Because only lowercase is considered this time,
     * only 26 array spaces are opened up */
    TrieNode[] next = new TrieNode[26];

    public TrieNode(){}

    public TrieNode(char val){
        this.val = val;
    }

}

public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = root; // 将currNode指向root对象
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (currNode.next[c - 'a'] == null){
                currNode.next[c - 'a'] = new TrieNode(c);
            }
            currNode = currNode.next[c - 'a'];
        }
        currNode.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currNode = root;
        int len = word.length();
        for (int i = 0; i < len; ++i){
            char c = word.charAt(i);
            if (currNode.next[c - 'a'] == null){
                return false;
            }
            currNode = currNode.next[c - 'a'];
        }
        return currNode.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        int len = prefix.length();
        for (int i = 0; i < len; ++i){
            char c = prefix.charAt(i);
            if (currNode.next[c - 'a'] == null){
                return false;
            }
            currNode = currNode.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
