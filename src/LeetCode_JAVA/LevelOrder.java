package LeetCode_JAVA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    private List<Integer> res = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

}
