package LeetCode_JAVA.BinaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeInLevelOrder {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root == null){
                res.append("#_");
            } else {
                res.append(root.val).append("_");
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, values);
        return reconLevelOrder(queue);
    }

    public TreeNode reconLevelOrder(Queue<String> queue){
        if (queue.element().equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            String val = queue.poll();
            if (!val.equals("#")){
                node.left = new TreeNode(Integer.parseInt(val));
                nodes.offer(node.left);
            }
            val = queue.poll();
            if (!val.equals("#")){
                node.right = new TreeNode(Integer.parseInt(val));
                nodes.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3,null,null,4,5]");
        SerializeInLevelOrder obj = new SerializeInLevelOrder();
        System.out.println(obj.deserialize(obj.serialize(t)));
    }
}
