package LeetCode_JAVA.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    class QueueNode {
        TreeNode root;
        Integer depth;
        QueueNode(TreeNode root, int depth){
            this.root = root;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        QueueNode node;
        while (!queue.isEmpty()){
            node = queue.remove();
            int depth = node.depth;
            if (node.root.left == null && node.root.right == null){
                return node.depth;
            }
            if (node.root.left != null){
                queue.offer(new QueueNode(node.root.left, depth + 1));
            }
            if (node.root.right != null){
                queue.offer(new QueueNode(node.root.right, depth + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,5,3,4,null,6]");
        System.out.println(new MinDepth().minDepth(t));
    }

}
