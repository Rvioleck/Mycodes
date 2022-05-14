package LeetCode_JAVA.BinaryTree;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        int height = getHeight(root);
        return getNodeSum(root, 1, height);
    }

    public int getNodeSum(TreeNode root, int level, int height){
        if (root == null){
            return 0;
        }
        if (level == height){
            return root.val;
        }
        return getNodeSum(root.left, level + 1, height) + getNodeSum(root.right, level + 1, height);
    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
