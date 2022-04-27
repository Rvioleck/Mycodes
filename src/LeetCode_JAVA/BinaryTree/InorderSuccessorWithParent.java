package LeetCode_JAVA.BinaryTree;

public class InorderSuccessorWithParent {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node GetNextNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return GetLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && node != parent.left) {
                node = parent;
                parent = node.parent;
            }
            // parent == null || node == parent.left
            return parent;
        }
    }

    public Node GetLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
