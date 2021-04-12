package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    private final List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
//        TreeNode t = TreeNode.create("[1,2,2]");
        System.out.println(new PathSum().pathSum(t, 22));
    }
}
