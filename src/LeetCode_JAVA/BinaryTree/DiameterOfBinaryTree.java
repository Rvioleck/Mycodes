package LeetCode_JAVA.BinaryTree;

public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max;
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3,4,5,null,null]");
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(t));
    }

}
