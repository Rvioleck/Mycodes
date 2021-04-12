package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private final List<String> res = new ArrayList<>();

    private void dfs(TreeNode node, String path) { // 回溯过程中参数path要保证在继续遍历的过程中不变，因此用String而非StringBuffer
        if (node == null) {
            return;
        }
        StringBuilder path0 = new StringBuilder(path);
        path0.append(Integer.valueOf(node.val));
        if (node.left == null && node.right == null) {
            res.add(path0.toString());
            return;
        }
        path0.append("->");
        dfs(node.left, path0.toString());
        dfs(node.right, path0.toString());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, "");
        return res;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,null,3,4]");
        System.out.println(new BinaryTreePaths().binaryTreePaths(t));
    }

}
