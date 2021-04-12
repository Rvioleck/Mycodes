package LeetCode_JAVA.BinaryTree;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return getDepthDiff(root) != -1;
    }

    private int getDepthDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepthDiff(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepthDiff(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new IsBalanced().isBalanced(t));
    }
}
