package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigzag {

    private final List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrderZigzag(TreeNode root) {
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.offer(root);
        int size = queue.size();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            while (size-- > 0) {
                node = queue.remove();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (!reverse) {
                    oneLevel.add(node.val);
                } else {
                    oneLevel.add(0, node.val);
                }
            }
            reverse = !reverse;
            size = queue.size();
            list.add(oneLevel);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new LevelOrderZigzag().levelOrderZigzag(t1));
    }
}
