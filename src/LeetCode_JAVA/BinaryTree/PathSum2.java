package LeetCode_JAVA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum2 {

    private int count = 0;

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            dfs(node, sum);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[2,3,3,3,3,3,3]");
        System.out.println(new PathSum2().pathSum(t, 8));
    }

}
