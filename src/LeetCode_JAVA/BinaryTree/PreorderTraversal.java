package LeetCode_JAVA.BinaryTree;


import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }
}
