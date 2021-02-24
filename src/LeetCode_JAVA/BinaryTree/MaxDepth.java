package LeetCode_JAVA.BinaryTree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,5,3,4,null,6]");
        System.out.println(new MaxDepth().maxDepth(t));
    }
}
