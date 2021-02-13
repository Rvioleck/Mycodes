package LeetCode_JAVA;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        return res;
    }

    public List<Integer> postOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right != null && node.right != last){
                    node = node.right;
                } else {
                    node = stack.pop();
                    res.add(node.val);
                    last = node;
                    node = null;
                }
            }
        }
        return res;
    }

}
