package LeetCode_JAVA.BinaryTree;

public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l == null ? r : (r == null ? l : root);
    }

}
