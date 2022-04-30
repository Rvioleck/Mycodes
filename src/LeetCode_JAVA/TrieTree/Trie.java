package LeetCode_JAVA.TrieTree;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {
    char val;  // 记录结点元素
    int isEnd; // 记录该结点作为结尾的个数
    int pass;  // 记录经过结点的个数
    /**
     * Store the next node of the trie tree.
     * Because only lowercase is considered this time,
     * only 26 array spaces are opened up
     */
    TrieNode[] next = new TrieNode[26];
    // HashMap<Char, Node> next; 字符太多的时候用哈希表
    // TreeMap<Char, Node> next;

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }

}

public class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curNode = root; // 将currNode指向root对象
        curNode.pass++;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (curNode.next[c - 'a'] == null) {
                curNode.next[c - 'a'] = new TrieNode(c);
            }
            curNode = curNode.next[c - 'a'];
            curNode.pass++;
        }
        curNode.isEnd++;
    }

    /**
     * Returns counts of the word in the trie.
     */
    public int search(String word) {
        if (word == null) return 0;
        TrieNode currNode = root;
        int len = word.length();
        for (int i = 0; i < len; ++i) {
            int idx = word.charAt(i) - 'a';
            if (currNode.next[idx] == null) {
                return 0;
            }
            currNode = currNode.next[idx];
        }
        return currNode.isEnd;
    }

    /**
     * Returns if the word is in the trie.
     * Realization of recursion
     */
    public boolean search2(String word){
        return match(word, root, 0);
    }

    public boolean match(String word, TrieNode currNode, int i){
        // 基本思路是：根据word和i得到此时的字符，然后看该字符是否与此时的节点node配对————即node.next[idx]有值(!=null)
        if (i == word.length()){
            return currNode.isEnd == 1;
        }
        int idx = word.charAt(i) - 'a';
        return currNode.next[idx] != null && match(word, currNode.next[idx], i + 1);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public int startsWith(String prefix) {
        if (prefix == null) return 0;
        TrieNode curNode = root;
        int len = prefix.length();
        for (int i = 0; i < len; ++i) {
            int idx = prefix.charAt(i) - 'a';
            if (curNode.next[idx] == null) {
                return 0;
            }
            curNode = curNode.next[idx];
        }
        return curNode.pass;
    }

    public void delete(String word){
        if (search(word) != 0){
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int index = 0;
            for (char ch : chs) {
                index = ch - 'a';
                if (--node.next[index].pass == 0) {
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.isEnd--;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search2("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search2("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.search2("app"));
    }

}
