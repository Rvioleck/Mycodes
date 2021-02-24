package LeetCode_JAVA.BinaryTree;

public class LongestUnivaluePath {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        int leftArrow = 0, rightArrow = 0;
        if (root.left != null && root.left.val == root.val) {
            leftArrow = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightArrow = right + 1;
        }
        max = Math.max(max, leftArrow + rightArrow);
        return Math.max(leftArrow, rightArrow);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[5,5,null,5]");
//        TreeNode t = TreeNode.create("[5,4,5,1,1,null,5]");
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(t));
    }

}
