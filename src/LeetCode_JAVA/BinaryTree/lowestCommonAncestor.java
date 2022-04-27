package LeetCode_JAVA.BinaryTree;

public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null){
            // l和r都不为空时，p和q则分别从两侧返回上来
            return root;
        }
        // 将不空的子树上传
        return l != null ? l : r;
    }

}