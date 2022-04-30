package LeetCode_JAVA.BinaryTree;

public class SumLeafNode {

    /**
     * https://www.lintcode.com/problem/1577/
     * 求叶结点的和
     */


    public int sumLeafNode(TreeNode root) {
        // Write your code here
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        return sumLeafNode(root.left) + sumLeafNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3,4,5]");
        System.out.println(new SumLeafNode().sumLeafNode(t));
    }
}
