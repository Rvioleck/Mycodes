package LeetCode_JAVA.DFS_BFS;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * 给定一个 N 叉树，找到其最大深度。
 */
public class MaxDepth {

    public static void main(String[] args) {
        Node root = new Node();
        System.out.println(new MaxDepth().maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxSubDepth = 0;
        for (Node child : root.children) {
            maxSubDepth = Math.max(maxSubDepth, maxDepth(child));
        }
        return maxSubDepth + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
