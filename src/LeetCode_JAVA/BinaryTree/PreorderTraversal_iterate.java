package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_iterate {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = new TreeNode();
        while (node != null && !stack.isEmpty()) {
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }

}
