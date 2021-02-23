package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    private final List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new InorderTraversal().inorderTraversal(t1));
    }

}
