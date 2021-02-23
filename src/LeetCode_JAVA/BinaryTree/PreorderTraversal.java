package LeetCode_JAVA.BinaryTree;


import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    private final List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new PreorderTraversal().preorderTraversal(t1));
    }
}
