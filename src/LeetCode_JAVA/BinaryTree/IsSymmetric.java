package LeetCode_JAVA.BinaryTree;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean b0 = left.val == right.val;
        boolean b1 = symmetric(left.right, right.left);
        boolean b2 = symmetric(left.left, right.right);
        return b0 && b1 && b2;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,2,3,4,4,3]");
        System.out.println(new IsSymmetric().isSymmetric(t));
    }

}
