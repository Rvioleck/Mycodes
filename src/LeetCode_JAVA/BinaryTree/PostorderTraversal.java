package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    private final List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new PostorderTraversal().postorderTraversal(t1));
    }

}
