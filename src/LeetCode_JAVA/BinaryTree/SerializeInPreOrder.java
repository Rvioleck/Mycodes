package LeetCode_JAVA.BinaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeInPreOrder {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, values);
        return reconPreorder(queue);
    }

    public TreeNode reconPreorder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = reconPreorder(queue);
        root.right = reconPreorder(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3,null,null,4,5]");
        SerializeInPreOrder obj = new SerializeInPreOrder();
        System.out.println(obj.deserialize(obj.serialize(t)));
    }

}
