package LeetCode_JAVA.BinaryTree;

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

    }

}
